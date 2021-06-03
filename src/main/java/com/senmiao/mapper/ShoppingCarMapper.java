package com.senmiao.mapper;

import com.senmiao.domain.ShoppingCar;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCarMapper {

    //获取用户购物表中的商品信息，不包括逻辑删除了的记录
    @Select("select id,number,user_id as userId,goods_id as goodsId " +
            "from shoppingcar where user_id = #{uid} and status != 2")
    List<ShoppingCar> selectShoppingCarByUid(Integer uid);
}
