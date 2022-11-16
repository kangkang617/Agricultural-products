package com.kangkang.config;

/**
 * ClassName:LoginInterceptorConfigurer
 * Package:com.kangkang.store.config
 * Description:
 *
 * @date:2022/3/25 13:47
 * @author:kangkang
 */

import com.kangkang.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器拦截器的注册
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    //创建自定义的拦截器对象
    HandlerInterceptor interceptor = new LoginInterceptor();



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns = new ArrayList<>();


        registry.addInterceptor(interceptor)
                /*.addPathPatterns("/**")*/
                .excludePathPatterns(patterns);
    }
}
