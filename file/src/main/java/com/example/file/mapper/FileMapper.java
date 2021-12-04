package com.example.file.mapper;

import com.example.file.entity.File;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xxh
 * @since 2021-11-10
 */
@Mapper
@Repository
public interface FileMapper extends BaseMapper<File> {

}
