package com.example.system.mapper;

import com.example.system.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 作者
 * @since 2021-10-27
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
