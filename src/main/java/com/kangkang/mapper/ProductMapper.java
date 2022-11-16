package com.kangkang.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kangkang.entity.Product;
import com.kangkang.vo.ProductVo;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kangkang
 * @since 2022-04-18
 */
public interface ProductMapper extends BaseMapper<Product> {

    //根据溯源码查询
    Product selectBySourceCode(String sourceCode);

    List<Product> searchAllProduct();
}
