package com.kangkang.service;

import com.kangkang.common.utils.CommonMethodApi;
import com.kangkang.entity.Farmers;
import com.kangkang.entity.Product;
import com.kangkang.vo.ProductVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName:FarmerTest
 * Package:com.kangkang.service
 * Description:
 *
 * @date:2022/4/14 16:35
 * @author:kangkang
 */
@SpringBootTest
public class ProductTest {

    @Resource
    private IProductService productService;


    @Test
    public void insert(){
        Product product = new Product();

        product.setAddress("湖北恩施");
        product.setpName("土豆");
        product.setFarmCharge("kangkang");
        product.setAddressInfo("世界硒都");
        product.setFid(2);

        productService.addProduct(product);

    }

    @Test
    public void search(){
        Product product = productService.searchByPid(3);
        System.out.println(product);

    }

    @Test
    public void searchBySourceCode(){
        Product product = productService.searchBySourceCode("dffe029c-78e9");
        System.out.println(product);

    }

    @Test
    public void generateAndUpload(){
        productService.generateQR(1);
    }


    @Test
    public void updateInfo(){
        Product product = new Product();
        product.setCharge("kang");
        product.setPid(3);
        product.setPark("工业园区");
        product.setLight("12.22");
        productService.updateInfo(product);

    }

    @Test
    public void searchAll(){
        List<Product> productVos = productService.searchAllProduct();
        System.out.println(productVos);

    }

}
