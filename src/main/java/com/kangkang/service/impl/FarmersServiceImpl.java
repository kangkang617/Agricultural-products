package com.kangkang.service.impl;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangkang.common.utils.CommonMethodApi;
import com.kangkang.entity.Farmers;
import com.kangkang.entity.User;
import com.kangkang.mapper.FarmersMapper;
import com.kangkang.service.IFarmersService;
import com.kangkang.service.ex.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kangkang
 * @since 2022-04-14
 */

@Service
public  class FarmersServiceImpl extends ServiceImpl<FarmersMapper, Farmers> implements IFarmersService {


    @Resource
    private FarmersMapper farmersMapper;

    @Resource
    private CommonMethodApi commonMethodApi;

//    加密算法
    Digester md5 = new Digester(DigestAlgorithm.MD5);

/*    //创建解析器
    @Autowired
    private PasswordEncoder pw;*/

    /**
     * 注册用户
     * @param farmers
     */
    @Override
    public void addFarmer(Farmers farmers,String code) {

            String code1 = commonMethodApi.returnCode();

        if (!code.equals(code1)){
            throw new CodeErrorException("验证码错误");
        }


        String phone = farmers.getPhone();

        Farmers byPhone = farmersMapper.selectByPhone(phone);

        if (byPhone != null) {
            throw new UserExistException("手机号已经存在");
        }



        //对密码加密
//        String password = pw.encode(farmers.getPassword());

//        完整信息
//        farmers.setPassword(password);

        String password = farmers.getPassword();

        String password2 = md5.digestHex(password);

        farmers.setPassword(password2);
        farmers.setCreatedTime(LocalDateTime.now());
        farmers.setModifiedTime(LocalDateTime.now());
        farmers.setIsDelete(0);

        int insert = farmersMapper.insert(farmers);

        if (insert != 1){
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
    public Farmers loginFarmer(String phone, String password) {
        Farmers byPhone = farmersMapper.selectByPhone(phone);
        if (byPhone == null){
            throw new FarmerExistException("用户不存在");
        }
/*
        if (byPhone.getIsDelete() == null || byPhone.getIsDelete() == 1){
            throw new FarmerExistException("用户已删除");
        }*/

//        boolean matches = pw.matches(password, byPhone.getPassword());

        String password2 = md5.digestHex(password);

        String password1 = byPhone.getPassword();

        if (!password2.equals(password1)){
            throw  new PasswordCheckFailException("手机号或密码不正确");
        }

        Farmers farmers = new Farmers();
        farmers.setFid(byPhone.getFid());
        farmers.setUsername(byPhone.getUsername());
        farmers.setAvatar(byPhone.getAvatar());

        return farmers;


    }

    /**
     * 更新密码
     * @param fid
     * @param oldPassword
     * @param newPassword
     */
    public void changPw(int fid,String oldPassword,String newPassword ){
        Farmers farmer = (Farmers) farmersMapper.selectById(fid);

        if (farmer == null){
            throw new UserExistException("用户不存在");
        }

        String password = farmer.getPassword();
        if (!password.equals(oldPassword)){
            throw new PasswordCheckFailException("密码错误");
        }

        String password2 = md5.digestHex(newPassword);

        farmer.setPassword(password2);

        baseMapper.updateById(farmer);

    }


    /**
     * 更新信息
     * @param fid
     * @param gender
     * @param age
     */
    @Override
    public void updateInfo(Integer fid, Integer gender, Integer age) {
        Farmers farmer = (Farmers) farmersMapper.selectById(fid);

        if (farmer == null){
            throw new UserExistException("用户不存在");
        }

        farmer.setModifiedTime(LocalDateTime.now());
        farmer.setGender(gender);
        farmer.setAge(age);

        baseMapper.updateById(farmer);

    }


    /**
     * 上传头像
     * @param fid
     * @param fileName
     */
    @Override
    public void upAvatar(Integer fid, String fileName) {
        Farmers farmers = farmersMapper.selectById(fid);

        if (farmers == null){
            throw new UserExistException("用户不存在！");
        }


//        拼接完整路径地址
        farmers.setAvatar("https://kang-agricultural-1253599123.cos.ap-beijing.myqcloud.com/avatar/" + fileName);

        int i = farmersMapper.updateById(farmers);

        if (i != 1){
            throw new UpdateException("更新头像异常");
        }

    }


}
