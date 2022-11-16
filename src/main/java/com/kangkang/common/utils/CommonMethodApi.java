package com.kangkang.common.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.kangkang.common.api.CommonResult;
import com.kangkang.common.api.IErrorCode;
import com.kangkang.common.api.ResultCode;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.sun.org.apache.bcel.internal.classfile.Code;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ClassName:Code
 * Package:com.kangkang.common.utils
 * Description:
 *
 * @date:2022/4/15 10:27
 * @author:kangkang
 */
@Component
public class CommonMethodApi {


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 请求获取随机验证码
     * @return
     */
    public String getCode() {
        //定义取值范围
        String str = "0123456789";
        //容量为4
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            //遍历4次，拿到某个字符并且拼接
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        String code = sb.toString();

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set("code","6666");




        //发送短信

        /*ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
        //存放请求参数的map集合
        Map<String, Object> params = new HashMap<String, Object>();
        //接收者手机号码
        params.put("number", telNumber);
        //短信模板ID
        params.put("templateId", templateId);
        //短信模板参数
        String[] templateParams = new String[2];
        templateParams[0] = validateCode;
        templateParams[1] = invalidTimer;
        params.put("templateParams", templateParams);
        *//**
         * 1.send方法用于单条发送短信,所有请求参数需要封装到Map中;
         * 2.返回结果为json串：{ "code":0,"data":"发送成功"}
         * 3.备注：（code: 发送状态，0为成功。非0为发送失败，可从data中查看错误信息）
         *//*
        String result = client.send(params);
*/

        System.out.println(code);

        return code;
    }


    public String returnCode(){
        String code = (String) redisTemplate.opsForValue().get("code");
        return code;
    }


    /**
     * 上传文件
     * @return
     */

    public static void upload(String dir,String name){

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



//        String dir = "C:/Users/kangkang/Pictures/Screenshots/屏幕截图(1).png";
// 指定要上传的文件
        File localFile = new File(dir);
// 指定文件将要存放的存储桶
        String bucketName = "kang-agricultural-1253599123";
// 指定文件上传到 COS 上的路径，即对象键。例如对象键为folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = "/QR/" + name;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        cosClient.shutdown();

        System.out.println("上传成功");


    }


    /**
     * 生成二维码
     */
//    private static  String QR_CODE_IMAGE_PATH = "src/main/resources/images/";
    public static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException
    {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }
}
