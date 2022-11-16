package com.kangkang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kangkang.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kangkang
 * @since 2022-04-14
 */
public interface IUsersService extends IService<User> {

    /**
     * 注册用户
     * @param user
     */
    public void addUser(User user, String code);

    /**
     * 登录用户
     * @param phone
     * @param password
     */
    public User loginUser(String phone, String password);

    /**
     * 更新密码
     * @param uid
     * @param oldPassword
     * @param newPassword
     */
    public void changPw(int uid, String oldPassword, String newPassword);


    /**
     * 更新信息
     * @param uid
     * @param gender
     * @param age
     */
    public void updateInfo(Integer uid, Integer gender, Integer age);

    /**
     * 上传头像
     * @param uid
     * @param fileName
     */
    public void upAvatar(Integer uid,String fileName);

    /**
     * 根据token查用户
     * @param token
     * @return
     */
    User findUserByToken(String token);
}
