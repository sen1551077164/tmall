package com.senmiao.mapper;

import com.senmiao.domain.Image;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageMapper {
    @Select("select id,url,goods_id as goodsId from image")
    List<Image> getImagesByGoodsId(Integer goodsId);
}