package com.senmiao.domain;

import lombok.Data;

@Data
public class Goods {
    Integer id;
    String name;
    Double price;
    Double discount;
    String description;
    Integer stock;
    String material;
    String brand;
    String size;
    String time;//上市年份季度
    String color;
    String age;//适合的年龄段
    Integer categoryId;
}
