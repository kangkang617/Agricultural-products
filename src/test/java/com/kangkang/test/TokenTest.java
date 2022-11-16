package com.kangkang.test;

import com.kangkang.common.utils.JWTUtils;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;

/**
 * ClassName:File
 * Package:com.kangkang.test
 * Description:
 *
 * @date:2022/4/17 10:29
 * @author:kangkang
 */
@SpringBootTest
public class TokenTest {
    @Resource
    private JWTUtils jwtUtils;

    @Test
    public void parse(){

//        jwtUtils.parser("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMyIsImlhdCI6MTY1MjY5OTQ0MSwidWlkIjoxMywiZXhwIjoxNjUyNjk5NjIxfQ.wkMhPL6Jmsmxl2gU3qc_suRHTCC9p46IO_WzA52dCF8");

    }

}
