package com.senmiao.controller;

import com.senmiao.service.EstimationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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


    @ApiOperation(value = "通过商品id获取商品的评价",notes = "通过商品id获取商品的评价")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "id",value = "商品id"),
                    @ApiImplicitParam(name = "page",value = "页码数"),
                    @ApiImplicitParam(name = "size",value = "每页的大小")}
    )
    @PostMapping("/getEstimationByGoodsId/{id}/{page}/{size}")
    public Object getEstimationByGoodsId(@PathVariable Integer id,@PathVariable Integer page,@PathVariable Integer size){
        return  estimationService.getEstimationByGoodsId(id,page,size);
    }
}