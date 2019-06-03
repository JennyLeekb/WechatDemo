package com.lkb.dp.problems.pack;

import lombok.Data;

/**
 * @Description 商品
 * @Author lkb
 * @CreateDate: 2019/6/3
 */
@Data
public class Goods {
    //id
    private int id;
    //商品名称
    private String name;
    //商品价值
    private int value;
    //商品重量
    private int weight;
}
