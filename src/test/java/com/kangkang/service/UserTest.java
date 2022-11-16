package com.kangkang.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kangkang.entity.User;
import com.kangkang.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * ClassName:UserTest
 * Package:com.kangkang.service
 * Description:
 *
 * @date:2022/4/18 16:04
 * @author:kangkang
 */
@SpringBootTest
public class UserTest {

    @Resource
    private IUsersService usersService;

    @Test
    public void testReg(){
        User user = new User();

        user.setPhone("1102");
        user.setUsername("666");
        user.setPassword("666666");

        usersService.addUser(user,"234006");
    }

    @Test
    public void testUpdateAvatar(){
        usersService.upAvatar(10,"2022-4-26");
    }

}
