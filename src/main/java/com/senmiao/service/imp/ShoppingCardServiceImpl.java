package com.senmiao.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.senmiao.domain.ShoppingCar;
import com.senmiao.domain.Vo.ConcreteGoodsVo;
import com.senmiao.domain.Vo.ShoppingCarVo;
import com.senmiao.mapper.GoodsMapper;
import com.senmiao.mapper.ImageMapper;
import com.senmiao.mapper.ShoppingCarMapper;
import com.senmiao.service.ShoppingCardService;
import com.senmiao.util.MyPageInfo;
import com.senmiao.util.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCardServiceImpl implements ShoppingCardService {
    @Autowired
    private ShoppingCarMapper shoppingCarMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private ImageMapper imageMapper;

    @Override
    public RetResult getShoppingCarByUid(Integer uid, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        List<ShoppingCar> shoppingCars = shoppingCarMapper.selectShoppingCarByUid(uid);
        PageInfo<ShoppingCar> shoppingCarPageInfo = new PageInfo<>(shoppingCars);

        //结果列表
        List<ShoppingCarVo> shoppingCarVos = new ArrayList<>(shoppingCars.size());

        for (ShoppingCar shoppingCar : shoppingCars) {
            Integer goodsId = shoppingCar.getGoodsId();
            ConcreteGoodsVo concreteGoodsVo = new ConcreteGoodsVo();
            //获取商品的信息
            concreteGoodsVo.setGoods(goodsMapper.selectGoodsById(goodsId));
            //获取商品的图片
            concreteGoodsVo.setImages(imageMapper.getImagesByGoodsId(goodsId));
            ShoppingCarVo shoppingCarVo = new ShoppingCarVo();

            shoppingCarVo.setGoods(concreteGoodsVo);
            shoppingCarVo.setShoppingCar(shoppingCar);

            shoppingCarVos.add(shoppingCarVo);
        }
        //将分页信息保存
        MyPageInfo<ShoppingCarVo> shoppingCardVoMyPageInfo = new MyPageInfo<>(shoppingCarPageInfo);
        shoppingCardVoMyPageInfo.setList(shoppingCarVos);

        RetResult<MyPageInfo<ShoppingCarVo>> result = new RetResult<>(200, "成功", shoppingCardVoMyPageInfo);
        return result;
    }
}
