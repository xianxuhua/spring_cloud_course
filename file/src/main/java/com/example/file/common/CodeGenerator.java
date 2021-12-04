package com.example.file.common;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.PackageConfig;


public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/course", "root", "1160576878")
                .globalConfig(builder -> builder
                        .author("xxh")
                        .outputDir("/Users/xxh/projects/java/boot/course/file/src/main/java"))
                .packageConfig(builder -> builder.parent("com.example.file"))
                .strategyConfig(builder -> builder
                        .addInclude("file")
                        .entityBuilder()
                        .enableLombok()
                        .enableChainModel()
                                .controllerBuilder()
                                .enableRestStyle()
                                    .mapperBuilder()
                                    .enableMapperAnnotation()
                        )

                .execute();
    }
}