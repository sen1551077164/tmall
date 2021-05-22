package com.senmiao.service;


import com.senmiao.domain.Vo.ConcreteGoodsVo;
import com.senmiao.util.RetResult;

public interface GoodsService {
    RetResult<ConcreteGoodsVo> getConcreteGoodsById(Integer id);
    RetResult getSimpleGoodsByCategoryId(Integer id,Integer page,Integer size);
}
