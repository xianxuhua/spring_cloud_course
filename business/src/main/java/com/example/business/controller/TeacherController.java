package com.example.business.controller;


import com.example.business.entity.Teacher;
import com.example.business.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxh
 * @since 2021-11-06
 */
@RestController
public class TeacherController {
    @Autowired
    TeacherMapper m;

    @GetMapping("/teacher/{id}")
    public Teacher get(@PathVariable Integer id) {
        return m.selectById(id);
    }

}

