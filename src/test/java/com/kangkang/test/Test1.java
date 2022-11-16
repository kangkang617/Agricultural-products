package com.kangkang.test;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * ClassName:Test1
 * Package:com.kangkang.test
 * Description:
 *
 * @date:2022/4/22 22:33
 * @author:kangkang
 */
@SpringBootTest
public class Test1 {
    @Test
    public void test1(){
        /*Digester md5 = new Digester(DigestAlgorithm.MD5);
        String password = md5.digestHex("user.getPassword()");
        System.out.println(password);*/

        String s = UUID.randomUUID().toString().substring(0,13);
        System.out.println(s);

    }

}
