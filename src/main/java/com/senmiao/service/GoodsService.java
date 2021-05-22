package com.senmiao.service;


import com.senmiao.util.RetResult;

public interface GoodsService {
    RetResult getTopGoods(Integer id,Integer size);
}
