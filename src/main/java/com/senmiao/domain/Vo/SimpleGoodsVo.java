package com.senmiao.domain.Vo;

import com.senmiao.domain.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleGoodsVo {
    Integer id;
    String name;
    Double price;
    Image image;
}