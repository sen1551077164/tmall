package com.senmiao.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.senmiao.domain.Goods;
import com.senmiao.mapper.GoodsMapper;
import com.senmiao.service.GoodsService;
import com.senmiao.util.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public RetResult getTopGoods(Integer id, Integer size) {
        PageHelper.startPage(1,size);
        PageInfo goodsPageInfo = new PageInfo<>();
        List list = goodsMapper.selectTopGoods(id);
        goodsPageInfo.setList(list);
        return new RetResult(200,goodsPageInfo);
    }
}