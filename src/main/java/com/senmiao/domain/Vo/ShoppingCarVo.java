package com.senmiao.domain.Vo;

import com.senmiao.domain.ShoppingCar;
import lombok.Data;

@Data
public class ShoppingCarVo {
    private ConcreteGoodsVo goods;
    private ShoppingCar shoppingCar;
}
