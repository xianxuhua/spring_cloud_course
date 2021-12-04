package com.example.business.controller;


import com.example.business.common.Response;
import com.example.business.common.Validator;
import com.example.business.entity.Course;
import com.example.business.entity.Teacher;
import com.example.business.entity.TeacherCourse;
import com.example.business.mapper.CourseMapper;
import com.example.business.mapper.TeacherCourseMapper;
import com.example.business.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxh
 * @since 2021-11-06
 */
@RestController
public class TeacherCourseController {
    @Autowired
    TeacherCourseMapper m;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    CourseMapper courseMapper;

    @GetMapping("/teacherCourse")
    public Response<Course> courseListByTeacher(Integer teacherId) {
        Validator.require(teacherId, "讲师id");

        List<Course> courses = m.courseByTeacher("select * from course where id in (select course_id from teacher_course where teacher_id=" + teacherId + ")");
        return new Response<>(courses.size(), 1, courses, "");
    }

    @PostMapping("/teacherCourse")
    public int insert(@RequestBody TeacherCourse tc) {
        Validator.require(tc.getCourseId(), "课程id");
        Validator.require(tc.getTeacherId(), "讲师id");
        Validator.ifNotExists(teacherMapper, tc.getTeacherId(), "id");
        Validator.ifNotExists(courseMapper, tc.getCourseId(), "id");

        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.setCourseId(tc.getCourseId());
        teacherCourse.setTeacherId(tc.getTeacherId());
        return teacherCourse.getId();
    }
}

