package com.kangkang.service.impl;


import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangkang.common.utils.CommonMethodApi;
import com.kangkang.common.utils.JWTUtils;
import com.kangkang.entity.User;
import com.kangkang.mapper.UsersMapper;
import com.kangkang.service.IUsersService;
import com.kangkang.service.ex.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kangkang
 * @since 2022-04-14
 */
@Service

public class UsersServiceImpl extends ServiceImpl<UsersMapper,User> implements IUsersService {

    @Resource
    private UsersMapper usersMapper;

    @Resource
    private CommonMethodApi commonMethodApi;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

/*

    //创建解析器
    @Autowired
    private PasswordEncoder pw;
*/

    /**
     * 根据token查用户
     * @param token
     * @return
     */
    @Override
    public User findUserByToken(String token) {

        //token为空返回null
        if(token == null || token == ""){
            return null;
        }
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        //解析失败
        if(stringObjectMap ==null){
            return null;
        }
        //如果成功
        String userJson =  redisTemplate.opsForValue().get("token_"+token);
        if (userJson == null || userJson == "") {
            return null;
        }
        //user
        User user = JSONUtil.toBean(userJson,User.class);
        return user;
    }

    /**
     * 注册用户
     * @param user
     */
    @Override
    public void addUser(User user, String code) {

        String code1 = commonMethodApi.returnCode();



        if (code == null || !code.equals(code1)) {
            throw new CodeErrorException("验证码错误");
        }


        String phone = user.getPhone();

        User byPhone = usersMapper.selectByPhone(phone);

        if (byPhone != null) {
            throw new PhoneException("手机号已经存在");
        }


        //对密码加密
//        String password = pw.encode(farmers.getPassword());

        Digester md5 = new Digester(DigestAlgorithm.MD5);
        String password = md5.digestHex(user.getPassword());

//        完整信息
        user.setPassword(password);
        user.setCreatedTime(LocalDateTime.now());
        user.setModifiedTime(LocalDateTime.now());
        user.setIsDelete(0);
//        user.setGender(1);

        int insert = usersMapper.insert(user);



        if (insert != 1) {
            throw new InsertException("添加用户失败");
        }
    }

    /**
     * 登录用户
     * @param phone
     * @param password
     * @return
     */
    @Override
    public User loginUser(String phone, String password) {
        User byPhone = usersMapper.selectByPhone(phone);
        if (byPhone == null){
            throw new UserExistException("用户不存在");
        }
/*
        if (byPhone.getIsDelete() == null || byPhone.getIsDelete() == 1){
            throw new FarmerExistException("用户已删除");
        }*/

//        boolean matches = pw.matches(password, byPhone.getPassword());
        String password1 = byPhone.getPassword();
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        String password2 = md5.digestHex(password);

        if (!password2.equals(password1)){
            throw  new PasswordCheckFailException("手机号或密码不正确");
        }


        return byPhone;


    }


    /**
     * 更新密码
     * @param uid
     * @param oldPassword
     * @param newPassword
     */
    public void changPw(int uid,String oldPassword,String newPassword ){
        User user = usersMapper.selectById(uid);

        if (user == null){
            throw new UserExistException("用户不存在");
        }

        String password = user.getPassword();
        if (!password.equals(oldPassword)){
            throw new PasswordCheckFailException("密码错误");
        }

//        密码加密
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        String password2 = md5.digestHex(newPassword);

        user.setPassword(password2);
        user.setModifiedTime(LocalDateTime.now());

        usersMapper.updateById(user);

    }


    /**
     * 更新信息
     * @param uid
     * @param gender
     * @param age
     */
    @Override
    public void updateInfo(Integer uid, Integer gender, Integer age) {
        User user = usersMapper.selectById(uid);

        if (user == null){
            throw new UserExistException("用户不存在");
        }

        user.setModifiedTime(LocalDateTime.now());
        user.setGender(gender);
        user.setAge(age);

        usersMapper.updateById(user);

    }

    /**
     * 上传头像
     * @param uid
     * @param fileName
     */
    @Override
    public void upAvatar(Integer uid, String fileName) {
        User user = usersMapper.selectById(uid);

        if (user == null){
            throw new UserExistException("用户不存在！");
        }


//        拼接完整路径地址
        user.setAvatar("https://kang-agricultural-1253599123.cos.ap-beijing.myqcloud.com/avatar/" + fileName);

        int i = usersMapper.updateById(user);

        if (i != 1){
            throw new UpdateException("更新头像异常");
        }

    }
}
