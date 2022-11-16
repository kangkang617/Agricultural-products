package com.kangkang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kangkang.entity.Farmers;
import com.kangkang.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName:CRUDTest
 * Package:com.kangkang.mapper
 * Description:
 *
 * @date:2022/4/14 15:16
 * @author:kangkang
 */
@SpringBootTest
public class CRUDTest {

    @Resource
    private BaseMapper baseMapper;

    @Test
    public void insert(){
        Farmers farmers = new Farmers();
        farmers.setUsername("kangkang");
        farmers.setPassword("6666");
        farmers.setPhone("11666");

        int insert = baseMapper.insert(farmers);
        System.out.println(insert);

    }

    @Test
    public void select(){
        Farmers farmers = (Farmers) baseMapper.selectById(1);
        System.out.println(farmers);
    }

    @Test
    public void testLocalDateTime(){




        System.out.println(LocalDateTime.now());

    }

    @Resource
    private ProductMapper productMapper;

    @Test
    public void testSelectAll(){
        List<Product> products = productMapper.searchAllProduct();



    }
}
