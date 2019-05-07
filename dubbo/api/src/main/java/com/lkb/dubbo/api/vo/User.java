package com.lkb.dubbo.api.vo;

import java.io.Serializable;

/**
 * @Description 用户
 * @Author lkb
 * @CreateDate: 2019/5/7
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
