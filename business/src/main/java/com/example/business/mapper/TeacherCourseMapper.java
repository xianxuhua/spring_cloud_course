package com.example.business.mapper;

import com.example.business.entity.Course;
import com.example.business.entity.Teacher;
import com.example.business.entity.TeacherCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xxh
 * @since 2021-11-06
 */
@Mapper
@Repository
public interface TeacherCourseMapper extends BaseMapper<TeacherCourse> {
    @Select("${sql}")
    List<Course> courseByTeacher(@Param("sql") String sql);
}
