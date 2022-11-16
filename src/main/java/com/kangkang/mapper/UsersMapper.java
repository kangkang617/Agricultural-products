package com.kangkang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kangkang.entity.Farmers;
import com.kangkang.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kangkang
 * @since 2022-04-14
 */
public interface UsersMapper extends BaseMapper<User> {

    User selectByPhone(String phone);
}
