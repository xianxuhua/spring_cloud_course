package com.example.business.mapper;

import com.example.business.entity.Section;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
public interface SectionMapper extends BaseMapper<Section> {
    @Select("${sql}")
    void updateTime(@Param("sql") String sql);
}
