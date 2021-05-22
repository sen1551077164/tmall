package com.senmiao.util;

import lombok.*;

//返回结果
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RetResult<T> {
    int code;
    T data;
    String msg;
}
