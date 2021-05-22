package com.senmiao.controller;


import com.senmiao.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api("这是一个用于提供获取商品信息的接口")
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "通过商品id获取商品的详细信息",notes = "通过商品id获取商品的详细信息")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "id",value = "商品id")}
    )
    @PostMapping("/getConcreteGoods/{id}/")
    public Object getConcreteGoods(@PathVariable Integer id){
        return goodsService.getConcreteGoodsById(id);
    }

    @ApiOperation(value = "通过类别id获取商品的简要信息",notes = "通过类别id获取商品的简要信息")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "id",value = "类别id"),
            @ApiImplicitParam(name = "page",value = "页码数"),
            @ApiImplicitParam(name = "size",value = "每页的大小")}
    )
    @PostMapping("/getSimpleGoodsByCategoryId/{id}/{page}/{size}")
    public Object getSimpleGoodsByCategoryId(@PathVariable Integer id,@PathVariable Integer page,@PathVariable Integer size){
        return goodsService.getSimpleGoodsByCategoryId(id, page, size);
    }
}