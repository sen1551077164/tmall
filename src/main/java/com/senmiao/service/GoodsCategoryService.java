package com.senmiao.service;

import com.senmiao.util.RetResult;

public interface GoodsCategoryService {
    RetResult selectCategorys();
    RetResult getCategoryById(Integer id);
}