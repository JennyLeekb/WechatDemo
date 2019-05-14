package com.lkb.validation.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Description 用户
 * @Author lkb
 * @CreateDate: 2019/5/14
 */
@Data
public class User {

    @NotNull(message = "name 为空")
    @Size(min=1,max=5,message = "name 长度小于1或大于5")
    private String name;

}
