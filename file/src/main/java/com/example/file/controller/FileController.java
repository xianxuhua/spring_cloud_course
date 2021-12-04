package com.example.file.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.file.common.Constant;
import com.example.file.common.Response;
import com.example.file.common.ShortUUID;
import com.example.file.common.Validator;
import com.example.file.mapper.FileMapper;
import com.example.file.util.Base64ToMultiPartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxh
 * @since 2021-11-10
 */
@RestController
public class FileController {
    @Autowired
    FileMapper m;

    @GetMapping("/upload")
    public Response<com.example.file.entity.File> list() {
        List<com.example.file.entity.File> files = m.selectList(null);
        return new Response<>(files.size(), 1, files, "");
    }

    @PostMapping("/upload")
    public String upload(@RequestBody com.example.file.entity.File file) throws IOException {

        Validator.require(file.getCurSplitIndex(), "index");
        Validator.require(file.getSize(), "total_size");
        Validator.require(file.getSplitSize(), "size");
        Validator.require(file.getName(), "name");
        Validator.require(file.getSplitTotalCount(), "count");
        Validator.require(file.getSuffix(), "suffix");

        String fileBase64 = file.getFileBase64();
        System.out.println(fileBase64);
        MultipartFile multipartFile = Base64ToMultiPartFile.base64ToMultipart(fileBase64);

        String savePath = Constant.savePath + file.getFileKey() + "." + file.getSuffix();
        File f = new File(savePath);
        multipartFile.transferTo(f);

        file.setPath(Constant.savePath);
        file.setCreatedAt(LocalDateTime.now());
        file.setUpdatedAt(LocalDateTime.now());

        QueryWrapper<com.example.file.entity.File> wrapper = new QueryWrapper<>();
        wrapper.eq("file_key", file.getFileKey());
        com.example.file.entity.File beforeFile = m.selectOne(wrapper);
        if (beforeFile == null) {
            m.insert(file);
        } else {
            beforeFile.setCurSplitIndex(file.getCurSplitIndex());
            m.updateById(beforeFile);
        }
        return "http://localhost:9000/file/f/"+file.getFileKey()+"."+file.getSuffix();
    }
}
