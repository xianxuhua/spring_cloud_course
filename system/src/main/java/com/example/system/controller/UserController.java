package com.example.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.system.entity.User;
import com.example.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2021-10-27
 */
@RestController
public class UserController {
    @Autowired
    UserMapper m;

    @GetMapping("/user")
    public List<User> list() {
        QueryWrapper<User> w = new QueryWrapper<>();
        return m.selectList(w);
    }
}

