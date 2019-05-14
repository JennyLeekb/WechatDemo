package com.lkb.validation.vo;

import lombok.Data;

/**
 * 结果
 * @author lkb
 * @date 2019/5/14
 * @param
 * @return
 */
@Data
public class Result {

    //成功返回1  失败返回-1
    private int code;
    //返回信息
    private String message;
    //返回数据
    private Object data;

}
