package com.senmiao.domain.Vo;

import com.senmiao.domain.Estimation;
import com.senmiao.domain.Goods;
import com.senmiao.domain.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConcreteGoodsVo {
    Goods goods;
    List<Image> images;
}