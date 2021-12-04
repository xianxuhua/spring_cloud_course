package com.example.file.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    long total;
    int current;
    List<T> data;
    String msg;
}
