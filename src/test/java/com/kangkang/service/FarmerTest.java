package com.kangkang.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kangkang.common.utils.CommonMethodApi;
import com.kangkang.entity.Farmers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * ClassName:FarmerTest
 * Package:com.kangkang.service
 * Description:
 *
 * @date:2022/4/14 16:35
 * @author:kangkang
 */
@SpringBootTest
public class FarmerTest {

    @Resource
    private IFarmersService farmersService;

    @Resource
    private CommonMethodApi commonMethodApi;

    @Test
    public void getCode(){
        String code = commonMethodApi.getCode();
        String s = commonMethodApi.returnCode();
        System.out.println(s);
    }

    @Test
    public void insert(){
        Farmers farmers = new Farmers();
        farmers.setPhone("18536498854");
        farmers.setUsername("kang");
        farmers.setPassword("kangkang");

        farmersService.addFarmer(farmers,"771998");
    }

    @Test
    public void login(){
        Farmers farmers = farmersService.loginFarmer("18536498853", "kangkang");
        System.out.println(farmers);
    }

    @Test
    public void changePw(){
        farmersService.changPw(1,"6666","kkkk");
    }

    @Test
    public void updateInfo(){
        farmersService.updateInfo(1,1,66);
    }

}
