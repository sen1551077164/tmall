package com.senmiao.controller;

import com.senmiao.service.EstimationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "这是一个用于提供获取商品评价的接口",description = "这是一个用于提供获取商品评价的接口")
@RestController
@RequestMapping("/estimation")
public class EstimationController {

    @Autowired
    private EstimationService estimationService;

    @PostMapping("/getEstimationByGoodsId/{id}/{page}/{size}")
    public Object getEstimationByGoodsId(@PathVariable Integer id,@PathVariable Integer page,@PathVariable Integer size){
        return  estimationService.getEstimationByGoodsId(id,page,size);
    }
}