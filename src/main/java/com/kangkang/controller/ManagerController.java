package com.kangkang.controller;

import com.kangkang.common.api.CommonResult;
import com.kangkang.common.utils.CommonMethodApi;
import com.kangkang.entity.Farmers;
import com.kangkang.service.IFarmersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * ClassName:FarmerController
 * Package:com.kangkang.controller
 * Description:
 *
 * @date:2022/4/15 17:21
 * @author:kangkang
 */
@RestController
@RequestMapping("/manager")
@CrossOrigin
public class ManagerController extends CommonController {

    @Resource
    private IFarmersService farmersService;

    @Resource
    private CommonMethodApi commonMethodApi;

    /**
     * 注册
     * @param farmers
     * @return
     */
    @ApiOperation(value = "管理员注册")
    @PostMapping("/reg")
    public CommonResult<Void> reg(Farmers farmers,String code){

        farmersService.addFarmer(farmers,code);
        return new CommonResult<>(200);
    }

    /**
     * 登录
     * @param phone
     * @param password
     * @param session
     * @return
     */
    @ApiOperation(value = "管理员登录")
    @GetMapping("/login")
    public CommonResult<Farmers> login(String phone,
                            String password,
                            HttpSession session){
        Farmers farmer = farmersService.loginFarmer(phone,password);

        session.setAttribute("fid",farmer.getFid());
        session.setAttribute("username",farmer.getUsername());

        return  CommonResult.success(farmer);

    }

    /**
     * 管理员登出
     * @param session
     * @return
     */
    @ApiOperation(value = "管理员登出")
    @GetMapping("/logout")
    public CommonResult logout(HttpSession session){
        session.removeAttribute("fid");
        session.removeAttribute("username");

        return CommonResult.success("登出成功！");
    }


    /**
     * 更改密码
     * @param oldPassword
     * @param newPassword
     * @param session
     * @return
     */
    @ApiOperation(value = "管理员修改密码")
    @PutMapping("/changePw")
    public CommonResult changePassword(String oldPassword,String newPassword,HttpSession session){


        Integer fid = getFidFromSession(session);
        farmersService.changPw(fid,oldPassword,newPassword);


        return CommonResult.success(null);
    }

    /**根据用户ID修改信息*/
    @PutMapping("/updateInfo")
    @ApiOperation(value = "管理员修改信息")
    public CommonResult updateInfo(HttpSession session, Farmers farmers){
        Integer fid = getFidFromSession(session);

        Integer age = farmers.getAge();
        Integer gender = farmers.getGender();

        farmersService.updateInfo(fid,gender,age);


        return new CommonResult(200);
    }



    @ApiOperation(value = "上传头像")
    @GetMapping("/updateAvatar")
    public CommonResult updateAvatar(HttpSession session,String fileName){
        Integer fid = getFidFromSession(session);

        farmersService.upAvatar(fid,fileName);

        return CommonResult.success("上传头像成功！");
    }


    //    获取session中的id
    protected final Integer getFidFromSession(HttpSession session){
        int fid = Integer.parseInt(session.getAttribute("fid").toString());
        return fid;
    }

    //    获取session中的usernaem
    public final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }



}
