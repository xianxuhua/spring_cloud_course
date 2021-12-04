package com.example.system.common;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/course", "root", "1160576878")
                .globalConfig(builder -> builder
                        .author("xxh")
                        .outputDir("/Users/xxh/projects/java/boot/course/system/src/main/java"))
                .packageConfig(builder -> builder.parent("com.example.system"))
                .strategyConfig(builder -> builder.addInclude("user"))
                .execute();
    }
}