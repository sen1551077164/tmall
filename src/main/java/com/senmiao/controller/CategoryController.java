package com.senmiao.controller;

import com.senmiao.service.GoodsCategoryService;
import com.senmiao.util.RetResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "这是一个用于提供获取商品分类信息的接口",description = "这是一个用于提供获取商品分类信息的接口")
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @ApiOperation(value = "这是一个获取所有分类的接口",notes = "这是一个获取所有分类的接口")
    @PostMapping("/getCategorys")
    @ResponseBody
    public Object getCategorys(){
        RetResult retResult = goodsCategoryService.selectCategorys();
        System.out.println(retResult);
        return retResult;
    }
}