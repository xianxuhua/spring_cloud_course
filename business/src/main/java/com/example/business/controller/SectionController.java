package com.example.business.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.business.common.Response;
import com.example.business.common.Validator;
import com.example.business.entity.Section;
import com.example.business.mapper.CourseMapper;
import com.example.business.mapper.SectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxh
 * @since 2021-10-31
 */
@RestController
public class SectionController {
    @Autowired
    SectionMapper m;

    @GetMapping("/section")
    public Response<Section> list(Integer courseId) {
        Validator.require(courseId, "courseId");

        QueryWrapper<Section> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        List<Section> sections = m.selectList(wrapper);
        return new Response<>(sections.size(), 1, sections, "");
    }
    
    @PostMapping("/section")
    @Transactional
    public Section insert(@RequestBody Section s) {
        Validator.require(s.getChapterId(), "chapter");
        Validator.require(s.getCourseId(), "courseId");
        Validator.require(s.getTitle(), "title");

        Section section = Section.builder()
                .title(s.getTitle())
                .chapterId(s.getChapterId())
                .courseId(s.getCourseId())
                .video(s.getVideo())
                .sort(s.getSort())
                .time(s.getTime())
                .createdAt(LocalDateTime.now())
                .build();

        section.setChapterId(s.getChapterId());
        m.insert(section);

        // 更新课程时长
        m.updateTime("update course set `time` = (select sum(`time`) from section where course_id="+s.getCourseId()+") where id="+s.getCourseId());
        return section;
    }
}

