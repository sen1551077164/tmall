package com.senmiao.util;

import lombok.*;

//θΏεη»ζ
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RetResult<T> {
    int code;
    String msg;
    T data;
}
