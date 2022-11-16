package com.kangkang.controller;

import com.kangkang.common.api.CommonResult;
import com.kangkang.service.ex.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * ClassName:CommonController
 * Package:com.kangkang.controller
 * Description:
 *
 * @date:2022/4/16 15:56
 * @author:kangkang
 */
public class CommonController {
    /**
     *操作成功状态码
     */
    public static final int OK = 200;


    //    请求处理方法，这个方法的返回值就是需要传递给 前端的值
    @ExceptionHandler(ServiceException.class)
    public CommonResult<Void> handleException(Throwable e) {
        CommonResult<Void> result = new CommonResult<>();
        result.setCode(200);
        result.setMessage("操作成功！");


        if (e instanceof PhoneException) {
            result.setCode(666);
            result.setMessage("手机号已经存在了！");
        } else if (e instanceof InsertException) {
            result.setCode(888);
            result.setMessage("插入数据时服务器宕机！");
        } else if (e instanceof PasswordCheckFailException) {
            result.setCode(889);
            result.setMessage("密码错误！");
        } else if (e instanceof UserExistException) {
            result.setCode(889);
            result.setMessage("用户不存在！");
        }else if (e instanceof CodeErrorException) {
            result.setCode(889);
            result.setMessage("验证码错误！");
        }else if (e instanceof ProductExistException) {
            result.setCode(889);
            result.setMessage("作物不存在");
        }else if (e instanceof UpdateException) {
            result.setCode(900);
            result.setMessage("更新失败！");
        }

        return result;

    }

 /*   //    获取session中的id
    protected final Integer getUidFromSession(HttpSession session){
        int uid = Integer.parseInt(session.getAttribute("uid").toString());
        return uid;
    }

    //    获取session中的usernaem
    public final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }*/
}
