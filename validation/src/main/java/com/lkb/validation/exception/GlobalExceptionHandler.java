package com.lkb.validation.exception;

import com.lkb.validation.vo.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @Description 全局异常处理
 * @Author lkb
 * @CreateDate: 2019/5/14
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        Result result = new Result();
        result.setCode(0);
        result.setData("");
        result.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
        return result;
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public Result ConstraintViolationExceptionHandler(ConstraintViolationException e){
        Result result = new Result();
        result.setCode(0);
        result.setData("");
        Set<ConstraintViolation<?>> set = e.getConstraintViolations();
        StringBuilder stringBuilder = new StringBuilder();
        for(ConstraintViolation violation : set){
            stringBuilder.append(violation.getMessage());
        }
        result.setMessage(stringBuilder.toString());
        return result;
    }

}
