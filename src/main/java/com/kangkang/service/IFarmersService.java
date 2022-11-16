package com.kangkang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kangkang.entity.Farmers;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kangkang
 * @since 2022-04-14
 */
public interface IFarmersService extends IService<Farmers> {

    /**
     * 注册用户
     * @param farmers
     */
    public void addFarmer(Farmers farmers,String code);

    /**
     * 登录用户
     * @param phone
     * @param password
     */
    public Farmers loginFarmer(String phone,String password);

    /**
     * 更新密码
     * @param fid
     * @param oldPassword
     * @param newPassword
     */
    public void changPw(int fid,String oldPassword,String newPassword );


    /**
     * 更新信息
     * @param fid
     * @param gender
     * @param age
     */
    public void updateInfo(Integer fid,Integer gender,Integer age );

    /**
     * 上传头像
     * @param fid
     * @param fileName
     */
    public void upAvatar(Integer fid,String fileName);

}
