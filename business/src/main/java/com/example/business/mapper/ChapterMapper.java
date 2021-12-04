package com.example.business.mapper;

import com.example.business.entity.Chapter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xxh
 * @since 2021-10-27
 */
@Repository
@Mapper
public interface ChapterMapper extends BaseMapper<Chapter> {

}
