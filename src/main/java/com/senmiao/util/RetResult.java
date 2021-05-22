package com.senmiao.util;

import lombok.Getter;
import lombok.Setter;

//返回结果
@Getter
@Setter
public class RetResult<T> {
    int code;
    T data;

    public RetResult(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public RetResult() {
    }

}
