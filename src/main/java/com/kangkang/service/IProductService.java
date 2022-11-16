package com.kangkang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kangkang.entity.Product;
import com.kangkang.vo.ProductVo;

import java.io.File;
import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kangkang
 * @since 2022-04-18
 */
public interface IProductService extends IService<Product> {
//    添加作物
    Integer addProduct(Product product);

//    查询作物
    Product searchByPid(Integer pid);

//    查询所有作物
    List<Product> searchAllProduct();

//    根据溯源码查询作物
    Product searchBySourceCode(String sourceCode);

//     生成二维码
    String generateQR(Integer pid);

//    添加作物信息
    Integer updateInfo(Product product);


}
