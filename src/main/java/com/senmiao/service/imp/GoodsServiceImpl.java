package com.senmiao.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.senmiao.domain.Goods;
import com.senmiao.domain.Vo.GoodsVo;
import com.senmiao.mapper.GoodsMapper;
import com.senmiao.mapper.ImageMapper;
import com.senmiao.service.GoodsService;
import com.senmiao.util.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private ImageMapper imageMapper;


    @Override
    public RetResult<List<GoodsVo>> getTopGoods(Integer id, Integer size) {
        PageHelper.startPage(1,size);
        PageInfo goodsPageInfo = new PageInfo<>();
        List<Goods> goods = goodsMapper.selectTopGoods(id);
        ArrayList<GoodsVo> goodsVos = new ArrayList<>(goods.size());
        goods.forEach(e->{
            goodsVos.add(new GoodsVo(e,imageMapper.getImagesByGoodsId(e.getId())));
        });
        goodsPageInfo.setList(goodsVos);
        return new RetResult(200, "成功",goodsPageInfo);
    }
}