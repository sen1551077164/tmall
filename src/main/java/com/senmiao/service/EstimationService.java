package com.senmiao.service;


import com.senmiao.util.RetResult;

public interface EstimationService {
    RetResult getEstimationByGoodsId(Integer id,Integer page,Integer size);
}
