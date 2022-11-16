package com.kangkang.test;

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
import org.springframework.http.HttpRequest;

import java.io.File;

import static com.qcloud.cos.demo.BucketRefererDemo.cosClient;

/**
 * ClassName:File
 * Package:com.kangkang.test
 * Description:
 *
 * @date:2022/4/17 10:29
 * @author:kangkang
 */
@SpringBootTest
public class FileTest {
    @Test
    public void upload(){
// 1 初始化用户身份信息（secretId, secretKey）。
// SECRETID和SECRETKEY请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = "AKIDIOHvKTN1QZS5TbVAalgNp1yhAOM4XkhO";
        String secretKey = "UCj2kHafV8WgbJm11nLejammX3KL7duv";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
// 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-beijing");
        ClientConfig clientConfig = new ClientConfig(region);
// 这里建议设置使用 https 协议
// 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
// 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);



        String dir = "C:/Users/kangkang/Pictures/Screenshots/屏幕截图(1).png";
// 指定要上传的文件
        File localFile = new File(dir);
// 指定文件将要存放的存储桶
        String bucketName = "kang-agricultural-1253599123";
// 指定文件上传到 COS 上的路径，即对象键。例如对象键为folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = "/Screenshots/屏幕截图(1).png";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        cosClient.shutdown();

        System.out.println("上传成功");



    }

}
