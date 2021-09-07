package com.example.kafkatest.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * stu_info
 * @author 
 */
@ApiModel(value="com.example.kafkatest.beans.StuInfo")
@Data
public class StuInfo implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名")
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty(value="年龄")
    private Integer age;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 2k评分
     */
    @ApiModelProperty(value="2k评分")
    private String score;

    private static final long serialVersionUID = 1L;
}