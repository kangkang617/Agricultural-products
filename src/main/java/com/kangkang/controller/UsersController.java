package com.kangkang.controller;

import cn.hutool.json.JSONUtil;
import com.kangkang.common.api.CommonResult;
import com.kangkang.common.utils.CommonMethodApi;
import com.kangkang.common.utils.JWTUtils;
import com.kangkang.entity.Farmers;
import com.kangkang.entity.User;
import com.kangkang.service.IUsersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.json.Json;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:FarmerController
 * Package:com.kangkang.controller
 * Description:
 *
 * @date:2022/4/15 17:21
 * @author:kangkang
 */
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController extends CommonController {

    @Resource
    private IUsersService iUsersService;

    @Resource
    private CommonMethodApi commonMethodApi;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 注册
     * @param
     * @return
     */
//   跨域

    @ApiOperation(value = "用户注册")
    @PostMapping("/reg")
    public CommonResult<Void> reg( User User, String code){

        iUsersService.addUser(User,code);

        return new CommonResult<>(200,"注册成功");
    }

    /**
     * 登录
     * @param phone
     * @param password
     * @param session
     * @return
     */
    @ApiOperation(value = "用户登录")
    @GetMapping("/login")
    public CommonResult<User> login(String phone,
                            String password,
                            HttpSession session){
        User user = iUsersService.loginUser(phone, password);

        String token = JWTUtils.createToken(user.getUid());

        redisTemplate.opsForValue().set("token_"+token, JSONUtil.toJsonStr(user),1, TimeUnit.DAYS);

        /*session.setAttribute("uid",user.getUid());
        session.setAttribute("username",user.getUsername());*/

        return CommonResult.success(token);

    }

    /**
     * 用户登出
     * @param token
     * @return
     */
    @ApiOperation(value = "用户登出")
    @GetMapping("/logout")
    public CommonResult logout(@RequestHeader("Authorization") String token){
//        session.removeAttribute("uid");
//        session.removeAttribute("username");

        redisTemplate.delete("token_"+token);
        return CommonResult.success("登出成功！");
    }


    /**
     * 更改密码
     * @param oldPassword
     * @param newPassword
     * @param session
     * @return
     */
    @ApiOperation(value = "更新密码")
    @PutMapping("/changePw")
    public CommonResult changePassword(String oldPassword,String newPassword,HttpSession session){


        Integer uid = getUidFromSession(session);
        iUsersService.changPw(uid,oldPassword,newPassword);


        return CommonResult.success("更改密码成功");
    }


    /**根据用户ID修改信息*/
    @ApiOperation(value = "更新信息")
    @PutMapping("/updateInfo")
    public CommonResult updateInfo(HttpSession session, User user){
        Integer uid = getUidFromSession(session);

        Integer age = user.getAge();
        Integer gender = user.getGender();

        iUsersService.updateInfo(uid,gender,age);


        return new CommonResult(200);
    }

    /**
     *
     * @param session
     * @param fileName
     * @return
     */
    @ApiOperation(value = "上传头像")
    @PostMapping("/updateAvatar")
    public CommonResult updateAvatar(HttpSession session,String fileName){
        Integer uid = getUidFromSession(session);

        iUsersService.upAvatar(uid,fileName);

        return CommonResult.success("上传头像成功！");
    }











    //    获取session中的id

    protected final Integer getUidFromSession(HttpSession session){
        int fid = Integer.parseInt(session.getAttribute("uid").toString());
        return fid;
    }

 /*   //    获取session中的usernaem
    public final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
*/


}
