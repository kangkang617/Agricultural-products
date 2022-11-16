package com.kangkang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kangkang.entity.Farmers;
import org.springframework.context.annotation.Primary;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kangkang
 * @since 2022-04-14
 */
public interface FarmersMapper extends BaseMapper<Farmers> {

    Farmers selectByPhone(String phone);
}
