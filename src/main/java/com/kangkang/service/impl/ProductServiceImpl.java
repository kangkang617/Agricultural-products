package com.kangkang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.zxing.WriterException;
import com.kangkang.common.utils.CommonMethodApi;
import com.kangkang.entity.Product;
import com.kangkang.mapper.ProductMapper;
import com.kangkang.service.IProductService;
import com.kangkang.service.ex.*;
import com.kangkang.vo.ProductVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kangkang
 * @since 2022-04-18
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public Integer addProduct(Product product) {
        Integer fid = product.getFid();
        if (fid == null){
            throw new UserExistException("用户登录状态异常");
        }

        product.setCreatTime(LocalDateTime.now());
        product.setModifyTime(LocalDateTime.now());

        product.setSourceCode(UUID.randomUUID().toString().substring(0,13));



        int insert = productMapper.insert(product);
        if (insert != 1){
            throw new InsertException("插入时异常");
        }


        return null;
    }

    /**
     * 根据作物id查询作物
     * @param pid
     * @return
     */
    @Override
    public Product searchByPid(Integer pid) {
        Product product = baseMapper.selectById(pid);

        if (product == null){
            throw new ProductExistException("商品不存在");
        }

        return product;

    }

    /**
     * 根据溯源码查询
     * @param sourceCode
     * @return
     */
    @Override
    public Product searchBySourceCode(String sourceCode) {

        Product product = productMapper.selectBySourceCode(sourceCode);
        if (product == null){
            throw new ProductExistException("作物不存在");
        }

        return product;
    }

    /**
     * 生成二维码
     * @param pid
     * @return
     */
    @Override
    public String generateQR(Integer pid) {

//      windows
//        String path = "src/main/resources/images/";
//        linux
        String path = "/envirment/temp/QR/";
        String name = String.valueOf( System.currentTimeMillis()) + ".png";
        path += name;


//        System.out.println(QR_CODE_IMAGE_PATH);

        try {
            String pid1 = String.valueOf(pid);
//          本地地址
//            CommonMethodApi.generateQRCodeImage("http://192.168.52.201:8088/product/searchById?pid=" + pid1, 350, 350, path);
//            服务器地址
            CommonMethodApi.generateQRCodeImage("http://43.138.34.132:8088/product/searchById?pid=" + pid1, 350, 350, path);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }


        CommonMethodApi.upload(path,name);

//        删除文件
        File myObj = new File(path);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

        return 	"https://kang-agricultural-1253599123.cos.ap-beijing.myqcloud.com/QR/" + name;
    }


    @Override
    public Integer updateInfo(Product product) {

        int result = productMapper.updateById(product);

        if (result != 1 ){
            throw new UpdateException("更新数据异常");
        }

        return null;
    }

   /* @Override
    public List<ProductVo> searchAllProduct() {

        productMapper.searchAllProduct();

        return null;
    }*/


    public List<Product> searchAllProduct(){
        List<Product> product = productMapper.searchAllProduct();

        if (product == null){
            throw new SelectException("查询失败");
        }

        return product;

    }
}
