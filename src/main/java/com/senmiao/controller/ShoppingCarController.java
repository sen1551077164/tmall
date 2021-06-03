package com.senmiao.controller;

import com.senmiao.service.ShoppingCardService;
import com.senmiao.util.RetResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/shoppingCard")
public class ShoppingCarController {

    @Autowired
    private ShoppingCardService shoppingCardService;

    @ApiOperation(value = "获取用户的购物车",notes = "通过商品id获取商品的评价")
    @ApiImplicitParams(
            {       @ApiImplicitParam(name = "page",value = "页码数"),
                    @ApiImplicitParam(name = "size",value = "每页的大小")}
    )
    @PostMapping("/get/{page}/{size}")
    public Object getShoppingCar(HttpServletRequest request ,@PathVariable("page") Integer page, @PathVariable("size") Integer size){
//        Integer uid = (Integer) request.getSession().getAttribute("uid");
        Integer uid = 1;
        // todo 目前无登录功能无法获取用户id，此处uid写死
        return shoppingCardService.getShoppingCarByUid(uid, page, 10);
    }
}
