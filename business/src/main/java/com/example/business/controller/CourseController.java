package com.example.business.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.business.common.Response;
import com.example.business.common.Validator;
import com.example.business.entity.Course;
import com.example.business.entity.CourseCategory;
import com.example.business.entity.Section;
import com.example.business.mapper.CourseCategoryMapper;
import com.example.business.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxh
 * @since 2021-10-31
 */
@RestController
public class CourseController {
    @Autowired
    CourseMapper m;

    @Autowired
    CourseCategoryMapper courseCategoryMapper;

    @GetMapping("/course")
    public Response<Course> list(@RequestParam(required = false) Integer categoryId,
                                 @RequestParam(required = false) Integer level) {
        List<Course> courses;
        if (categoryId != null && level == 2) {
            // 根据二级分类查询，查询course_category表
            courses = m.selectByCategory("select * from course where id in (select course_id from course_category where category_id=" + categoryId + ")");
        }
        else if (categoryId != null && level == 1) {
            // 根据一级分类查询
            courses = m.selectByCategory("select * from course where id in (select course_id from course_category where category_id = (select id from category where parent = "+categoryId+" and level = 2))");
        } else {
            courses = m.selectList(null);
        }
        return new Response<>(courses.size(), 1, courses, "");
    }

    @PostMapping("/course")
    @Transactional
    public int insert(@RequestBody Course c) {
        Validator.require(c.getCategoryId(), "分类id");
        Validator.require(c.getName(), "课程名称");
        Validator.require(c.getFee(), "课程价格");
        Validator.require(c.getCoverImg(), "封面");
        Validator.require(c.getTime(), "课程时长");

        Validator.ifExists(m, c.getName(), "name");

        Course course = Course.builder()
                .name(c.getName())
                .coverImg(c.getCoverImg())
                .fee(c.getFee())
                .description(c.getDescription())
                .time(c.getTime())
                .build();
        m.insert(course);

        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setCourseId(course.getId());
        courseCategory.setCategoryId(c.getCategoryId());
        courseCategoryMapper.insert(courseCategory);

        return course.getId();
    }
}

