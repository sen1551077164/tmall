package com.senmiao.domain;

import lombok.Data;

@Data
public class ShoppingCar {
    Integer id;
    Integer number;
    Integer goodsId;
    Integer userId;
    Integer status;
}
