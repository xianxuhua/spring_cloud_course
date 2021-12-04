package com.example.business.mapper;

import com.example.business.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
public interface TeacherMapper extends BaseMapper<Teacher> {

}
