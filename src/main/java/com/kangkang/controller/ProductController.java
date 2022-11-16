package com.kangkang.controller;


import com.kangkang.common.api.CommonResult;
import com.kangkang.entity.Product;
import com.kangkang.service.IProductService;
import com.kangkang.vo.ProductVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kangkang
 * @since 2022-04-18
 */
@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController extends CommonController {

    @Resource
    private IProductService productService;

    @ApiOperation("添加作物")
    @PostMapping("/add")
    public CommonResult addProduct(HttpSession session, @RequestBody Product product){
        Integer fid = getFidFromSession(session);
        product.setFid(fid);

//        影响行数
        Integer integer = productService.addProduct(product);

        return CommonResult.success("添加成功！");
    }


    /**
     * 查询作物
     * @param pid
     * @return
     */
    @ApiOperation("根据ID查询作物")
    @GetMapping("/searchById")
    public CommonResult searchByID(Integer pid){
        Product product = productService.searchByPid(pid);

        return CommonResult.success(product,"查询成功");
    }

    /**
     * 根据溯源码查询作物
     * @param sourceCode
     * @return
     */
    @ApiOperation("根据溯源码查询作物")
    @GetMapping("/searchByCode")
    public CommonResult searchBySourceCode(String sourceCode){
        Product product = productService.searchBySourceCode(sourceCode);

        return CommonResult.success(product,"查询成功");


    }


    /**
     * 查询作物
     * @param pid
     * @return
     */
    @ApiOperation("生成二维码")
    @GetMapping("/generateQR")
    public CommonResult generateQR(Integer pid){

        String url = productService.generateQR(pid);

        return new CommonResult(200,"获取成功",url);
    }


    /**
     *
     * @param product
     * @return
     */
    @ApiOperation("添加信息")
    @PostMapping("/updateInfo")
    public CommonResult updateInfo(@RequestBody Product product){

        productService.updateInfo(product);

        return CommonResult.success("添加信息成功！");
    }


    @ApiOperation("查询表中所有信息")
    @GetMapping("/searchAllProduct")
    public CommonResult searchAllProduct(){
        List<Product> productVos = productService.searchAllProduct();

        return CommonResult.success(productVos,"查询成功！");
    }






    //    获取session中的id
    protected final Integer getFidFromSession(HttpSession session){
        int fid = Integer.parseInt(session.getAttribute("fid").toString());
        return fid;
    }

    //    获取session中的usernaem
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
