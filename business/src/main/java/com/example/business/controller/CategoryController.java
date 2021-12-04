package com.example.business.controller;


import com.example.business.common.Response;
import com.example.business.entity.Category;
import com.example.business.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxh
 * @since 2021-11-04
 */
@RestController
public class CategoryController {
    @Autowired
    CategoryMapper m;

    @GetMapping("/category")
    public Response<Category> list() {
        List<Category> categories = m.selectList(null);
        return new Response<>(categories.size(), 1, categories, "");
    }
}

