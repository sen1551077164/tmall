package com.senmiao.mapper;

import com.senmiao.domain.Goods;
import com.senmiao.util.RetResult;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    @Select("select id,name,price,description" +
            ",stock,material,brand,size,time" +
            ",color,age,discount,category_id as categoryId from goods " +
            "where category_id = #{id} order by id desc")
    List<Goods> selectTopGoodsByCategoryId(Integer id);

    @Select("select id,name,price,description" +
            ",stock,material,brand,size,time" +
            ",color,age,discount,category_id as categoryId from goods " +
            "where id = #{id} order by id desc")
    Goods selectGoodsById(Integer id);

    @Select("select id,name,price,description" +
            ",stock,material,brand,size,time" +
            ",color,age,discount,category_id as categoryId from goods " +
            "where name like concat('%',#{name},'%') order by id desc")
    List<Goods> selectGoodsByName(String name);
}
