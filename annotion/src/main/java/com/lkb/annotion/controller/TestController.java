package com.lkb.annotion.controller;

import com.lkb.annotion.context.HandlerContext;
import com.lkb.annotion.handler.Handler;
import com.lkb.annotion.utils.BeanFactory;
import com.lkb.annotion.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 测试
 * @Author lkb
 * @CreateDate: 2019/5/23
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/operate")
    public ResultVo operate(int type){
        ResultVo resultVo = new ResultVo();
        HandlerContext context = BeanFactory.getContext();
        Handler handler = context.getBean(type);
        handler.operate();
        resultVo.setCode(1);
        return resultVo;
    }
}
