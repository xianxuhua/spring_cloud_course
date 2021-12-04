package com.example.business.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xxh
 * @since 2021-10-31
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;

    private Integer courseId;

    private Integer chapterId;

    private String video;

    private Integer time;

    private Integer sort;

    private LocalDateTime createdAt;


}
