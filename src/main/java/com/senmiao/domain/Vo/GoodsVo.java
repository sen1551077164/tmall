package com.senmiao.domain.Vo;

import com.senmiao.domain.Goods;
import com.senmiao.domain.Image;
import lombok.Data;

import java.util.List;

@Data
public class GoodsVo{
    Goods goods;
    List<Image> images;

    public GoodsVo(Goods goods, List<Image> images) {
        this.goods = goods;
        this.images = images;
    }
}