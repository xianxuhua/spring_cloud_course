package com.example.business.mapper;

import com.example.business.entity.Course;
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
 * @since 2021-10-31
 */
@Mapper
@Repository
public interface CourseMapper extends BaseMapper<Course> {
    @Select("${sql}")
    List<Course> selectByCategory(@Param("sql") String sql);
}
