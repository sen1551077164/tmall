package com.senmiao.service;

import com.senmiao.util.RetResult;

public interface ShoppingCardService {
    RetResult getShoppingCarByUid(Integer uid,Integer page,Integer size);
}
