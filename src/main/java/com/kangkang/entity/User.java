package com.kangkang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author kangkang
 * @since 2022-04-14
 */
@TableName("t_user")
@ApiModel(value = "User对象", description = "")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("修改时间")
    private LocalDateTime modifiedTime;

    @ApiModelProperty("是否删除")
    private Integer isDelete;

    @ApiModelProperty("性别")
    private Integer gender;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("token")
    private String token;


}
