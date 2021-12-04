package com.example.business.common;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/course", "root", "1160576878")
                .globalConfig(builder -> builder
                        .author("xxh")
                        .outputDir("/Users/xxh/projects/java/boot/course/business/src/main/java"))
                .packageConfig(builder -> builder.parent("com.example.business"))
                .strategyConfig(builder -> builder
                        .addInclude("teacher_course")
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