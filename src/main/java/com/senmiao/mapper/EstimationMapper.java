package com.senmiao.mapper;

import com.senmiao.domain.Estimation;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstimationMapper {

    @Select("select id,content,time,user_id as userId," +
            " anonymous,goods_id as goodsId from estimation" +
            " where goods_id = #{id}")
    List<Estimation> selectEstimationByGoodsId(Integer id);
}