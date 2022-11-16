package com.kangkang.controller;

import com.kangkang.common.api.CommonResult;
import com.kangkang.common.utils.CommonMethodApi;
import com.zhenzi.sms.ZhenziSmsClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:ApiController
 * Package:com.kangkang.controller
 * Description:
 *
 * @date:2022/4/17 9:40
 * @author:kangkang
 */

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiController {
    @Resource
    private CommonMethodApi api;

    @Value("${sms.apiUrl}")
    private String apiUrl;

    @Value("${sms.appId}")
    private String appId;

    @Value("${sms.appSecret}")
    private String appSecret;


    /**
     * 获取验证码
     * @return
     */
    @ApiOperation(value = "获取验证码")
    @GetMapping("/getCode")
    public CommonResult getCode(String phone,HttpSession session) throws Exception {
        ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
        Map<String, Object> params = new HashMap<String, Object>();

        String code = api.getCode();

        params.put("number", phone);
        params.put("templateId", 9215);
        String[] templateParams = new String[2];
        templateParams[0] = code;
        templateParams[1] = "1分钟";
        params.put("templateParams", templateParams);
        session.setAttribute("code",code);


        String result = client.send(params);
        System.out.println(result);

        return CommonResult.success("获取验证码成功！");
    }

}
