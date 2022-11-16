package com.kangkang.interceptor;

import com.kangkang.common.utils.JWTUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:LoginInterceptor
 * Package:com.kangkang.store.interceptor
 * Description:
 *
 * @date:2022/3/25 13:40
 * @author:kangkang
 */



public class LoginInterceptor implements HandlerInterceptor {
    /**
     *  检测全局session对象中有没有uid，有则放行
     * @param request 请求
     * @param response 响应
     * @param handler 处理器
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)){
            //handler 可能是 RequestResourceHandler springboot 程序 访问静态资源 默认去classpath下的static目录去查询
            return true;
        }

        String token = request.getHeader("Authorization");

        if (token == null || token == ""){
            return false;
        }

        if (token == null || token == "" || JWTUtils.checkToken(token).get("uid") == null){
            response.sendRedirect("/web/login.html");
            return false;
        }

        return true;
    }
}
