package com.senmiao.controller;

import com.senmiao.service.GoodsCategoryService;
import com.senmiao.util.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @PostMapping("/getCategorys")
    @ResponseBody
    public Object getCategorys(){
        RetResult retResult = goodsCategoryService.selectCategorys();
        System.out.println(retResult);
        return retResult;
    }
}
