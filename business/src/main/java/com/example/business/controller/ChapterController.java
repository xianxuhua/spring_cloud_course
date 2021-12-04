package com.example.business.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.business.common.Response;
import com.example.business.common.Validator;
import com.example.business.entity.Chapter;
import com.example.business.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxh
 * @since 2021-10-27
 */
@RestController
public class ChapterController {
    @Autowired
    ChapterMapper m;

    @GetMapping("/chapter")
    public Response<Chapter> list(int current, int size) {
        Page<Chapter> chapterPage = m.selectPage(new Page<>(current, size), null);
        return new Response<>(chapterPage.getTotal(), current, chapterPage.getRecords(), "");
    }

    @PostMapping("/chapter")
    public int insert(@RequestBody Chapter c) {
        Validator.require(c.getName(), "name");
        Validator.require(c.getCourseId(), "course_id");

        Chapter chapter = new Chapter();
        chapter.setName(c.getName());
        chapter.setCourseId(c.getCourseId());
        m.insert(chapter);
        return chapter.getId();
    }

    @PatchMapping("/chapter")
    public Chapter update(@RequestBody Chapter c) {
        Validator.require(c.getId(), "id");
        Validator.require(m.selectById(c.getId()), "当前记录");

        m.updateById(c);
        return m.selectById(c.getId());
    }

    @DeleteMapping("/chapter/{id}")
    public int delete(@PathVariable int id) {
        Validator.require(id, "id");
        Validator.require(m.selectById(id), "当前记录");

        m.deleteById(id);
        return id;
    }
}

