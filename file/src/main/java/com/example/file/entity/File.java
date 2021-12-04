package com.example.file.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.beans.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xxh
 * @since 2021-11-10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String path;

    private String name;

    private String suffix;

    private Integer size;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer curSplitIndex;

    private Integer splitSize;

    private Integer splitTotalCount;

    private String fileKey;

//    忽略该字段，不进行插入
    @TableField(exist = false)
    private String fileBase64;

}
