package com.kangkang.vo;

import lombok.Data;

/**
 * ClassName:ProductVo
 * Package:com.kangkang.vo
 * Description:
 *
 * @date:2022/5/2 14:48
 * @author:kangkang
 */
@Data
public class ProductVo {
    private Integer pid;
    private Integer fid;
    private String park;
    private String charge;
    private String tempreature;
    private String humidity;
    private String light;
    private String soil;

}
