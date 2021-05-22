package com.senmiao.mapper;

import com.senmiao.util.RetResult;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    @Select("select id,name,price,description" +
            ",stock,material,brand,size,time" +
            ",color,age,discount from goods " +
            "where id = #{id} order by id desc")
    List selectTopGoods(Integer id);
}
