package com.example.business.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.business.common.Response;
import com.example.business.common.Validator;
import com.example.business.entity.CourseContent;
import com.example.business.mapper.CourseContentMapper;
import com.example.business.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxh
 * @since 2021-11-06
 */
@RestController
public class CourseContentController {
    @Autowired
    CourseContentMapper m;

    @Autowired
    CourseMapper courseMapper;

    @GetMapping("/courseContent")
    public CourseContent get(Integer courseId) {
        Validator.require(courseId, "课程id");

        QueryWrapper<CourseContent> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        return m.selectOne(wrapper);
    }

    @PostMapping("/courseContent")
    public int insert(@RequestBody CourseContent cc) {
        Validator.require(cc.getCourseId(), "课程id");
        Validator.ifNotExists(courseMapper, cc.getCourseId(), "id");

        CourseContent courseContent = new CourseContent();
        courseContent.setCourseId(cc.getCourseId());
        courseContent.setContent(cc.getContent());
        m.insert(courseContent);
        return courseContent.getId();
    }
}

