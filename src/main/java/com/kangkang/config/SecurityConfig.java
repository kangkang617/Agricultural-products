package com.kangkang.config;

/**
 * ClassName:SecurityConfig
 * Package:com.kangkang.config
 * Description:
 *
 * @date:2022/4/15 15:26
 * @author:kangkang
 */
//@Configuration
/*
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单提交
        http.formLogin()
        //自定义登录页面
//                .loginPage("/login.html")
        //当发现/login时认为是登录，必须和表单提交的地址一样。去执行UserServiceImpl
                .loginProcessingUrl("/login")
        //登录成功后跳转页面，POST请求
//                .successForwardUrl("/toMain")
                //和successForwardUrl不能共存
                .successHandler(new
                        MyAuthenticationSuccessHandler("http://www.baidu.com"));


        //失败后的地址
//                .failureForwardUrl("");
        //权限
        http.authorizeRequests()
        //login.html不需要被认证,放行页面和地址
                .antMatchers("/login.html").permitAll()
                .antMatchers("/farmer/login").permitAll()
                .antMatchers("/farmer/reg").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/user/reg").permitAll()
                .antMatchers("/api/**").permitAll()
                //swagger
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
//                允许可以请求options cors
                .antMatchers(HttpMethod.OPTIONS).permitAll()
        //所有请求都必须被认证，必须登录后被访问
                .anyRequest().authenticated();

        //关闭csrf防护
        http.csrf().disable();

//        禁止session
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        自定义权限拒绝处理类
//        http.exceptionHandling().
//                accessDeniedHandler(getRestfulAccessDeniedHandler())
////                没有登录
//                .authenticationEntryPoint(getRestfulAuthenticationEntryPoint());
////        加入jwt验证过滤器
//        http.addFilterBefore(getJwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);


    }


    @Bean
    public JwtAuthenticationTokenFilter getJwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }


    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public RestfulAccessDeniedHandler getRestfulAccessDeniedHandler(){
        return new RestfulAccessDeniedHandler();
    }

    @Bean
    public RestfulAuthenticationEntryPoint getRestfulAuthenticationEntryPoint(){
        return new RestfulAuthenticationEntryPoint();
    }


}
*/
