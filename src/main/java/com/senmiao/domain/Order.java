package com.senmiao.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    Integer id;
    String group;
    Date time;
    Integer goodsId;
    Integer userId;
    Integer status;
}
