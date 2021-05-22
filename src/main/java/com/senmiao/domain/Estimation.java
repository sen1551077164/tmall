package com.senmiao.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Estimation {
    private Integer id;
    private String content;
    private Date time;
    private Integer userId;
    private Integer anonymous;
    private Integer goodsId;
}
