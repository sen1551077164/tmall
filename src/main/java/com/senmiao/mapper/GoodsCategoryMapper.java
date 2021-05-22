package com.senmiao.mapper;

import com.senmiao.domain.GoodsCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsCategoryMapper {
    @Select("select id,name,create_time as createTime from goodsCategory")
    List<GoodsCategory> selectCategorys();

    @Select("select id,name,create_time as createTime from goodsCategory where id=#{id}")
    GoodsCategory getCategoryById(Integer id);
}