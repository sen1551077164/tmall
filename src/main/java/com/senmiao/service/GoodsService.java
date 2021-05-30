package com.senmiao.service;


import com.senmiao.util.RetResult;

public interface GoodsService {
    RetResult getConcreteGoodsById(Integer id);
    RetResult getSimpleGoodsByCategoryId(Integer id,Integer page,Integer size);
    RetResult getConcreteGoodsByName(String name,Integer page,Integer size);
}
