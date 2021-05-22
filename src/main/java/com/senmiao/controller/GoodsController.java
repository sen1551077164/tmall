package com.senmiao.controller;


import com.senmiao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @PostMapping("/getTop/{id}/{size}")
    public Object getTop(@PathVariable Integer id,@PathVariable Integer size){
        return goodsService.getTopGoods(id,size);
    }
}
