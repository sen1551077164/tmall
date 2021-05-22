package com.senmiao.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.senmiao.domain.Goods;
import com.senmiao.domain.Image;
import com.senmiao.domain.Vo.ConcreteGoodsVo;
import com.senmiao.domain.Vo.SimpleGoodsVo;
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

    /**
     * 通过商品id获取商品的具体信息以及评价
     * @param id
     * @return
     */
    @Override
    public RetResult getConcreteGoodsById(Integer id) {
        //获取商品信息
        Goods goods = goodsMapper.selectGoodsById(id);
        //获取商品图片
        List<Image> images = imageMapper.getImagesByGoodsId(goods.getId());
        return new RetResult<>(200,"成功",new ConcreteGoodsVo(goods,images));
    }

    /**
     * 根据类别id获取size个商品，然后将每个商品的id，name，price，image封装成一个简单商品类，
     * 最后将这个简单商品类列表传回前端
     * @param id 类别id
     * @param page 页码数
     * @param size 每页大小
     * @return
     */
    @Override
    public RetResult getSimpleGoodsByCategoryId(Integer id, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        PageInfo<SimpleGoodsVo> simpleGoodsVoPageInfo = new PageInfo<>();
        //获取该分类下的商品，并将部分信息放在简单商品类里
        List<Goods> goods = goodsMapper.selectTopGoodsByCategoryId(id);
        ArrayList<SimpleGoodsVo> simpleGoodsVos = new ArrayList<>(goods.size());
        for (Goods good : goods) {
            Image image = imageMapper.getOneImageByGoodsId(good.getId());
            simpleGoodsVos.add(new SimpleGoodsVo(good.getId(),good.getName(),good.getPrice(),image));
        }
        simpleGoodsVoPageInfo.setList(simpleGoodsVos);
        RetResult<PageInfo<SimpleGoodsVo>> result = new RetResult<>();
        //根据简单商品类里的对象个数判断是否有数据
        if (simpleGoodsVos.size() < 1){
            result.setCode(401);
            result.setMsg("该分类暂无商品");
            result.setData(null);
        }else {
            result.setCode(200);
            result.setMsg("成功");
            result.setData(simpleGoodsVoPageInfo);
        }
        return result;
    }
}