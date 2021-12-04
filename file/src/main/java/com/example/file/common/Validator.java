package com.example.file.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

public class Validator {
    public static void require(Serializable val, String fieldName) {
        if (val == null) {
            throw new ValidatorException(fieldName+"不能为空");
        }
    }

    public static void ifExists(BaseMapper m, Serializable val, String field) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq(field, val);
        Object o = m.selectOne(wrapper);
        System.out.println(o);
        if (o != null) {
            throw new ValidatorException(field+"='"+val+"'的记录已存在");
        }

    }

    public static void ifNotExists(BaseMapper m, Serializable val, String field) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq(field, val);
        Object o = m.selectOne(wrapper);
        if (o == null) {
            throw new ValidatorException(field+"='"+val+"'的记录不存在");
        }
    }

}

// RuntimeException不需要try catch
class ValidatorException extends RuntimeException {
    ValidatorException(String msg) {
        super(msg);
    }
}

// 如果发生ValidatorException则自动执行
@ControllerAdvice
class ControllerExceptionHandler {
    @ExceptionHandler(value = ValidatorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handle(ValidatorException e) {
        return new Response(0, 0, null, e.getMessage());
    }
}