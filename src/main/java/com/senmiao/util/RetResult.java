package com.senmiao.util;

import lombok.Getter;
import lombok.Setter;

//返回结果
@Getter
@Setter
public class RetResult<T> {
    int code;
    T data;
    String msg;

    public RetResult(int code,String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RetResult() {
    }

}
