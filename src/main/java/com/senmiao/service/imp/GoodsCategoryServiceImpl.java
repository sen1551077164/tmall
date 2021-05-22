package com.senmiao.service.imp;

import com.senmiao.domain.GoodsCategory;
import com.senmiao.domain.Vo.GoodsCategoryVo;
import com.senmiao.mapper.GoodsCategoryMapper;
import com.senmiao.service.GoodsCategoryService;
import com.senmiao.util.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    @Autowired
    GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public RetResult selectCategorys() {
        List<GoodsCategory> goodsCategories = goodsCategoryMapper.selectCategorys();
        ArrayList<GoodsCategoryVo> goodsCategoryVos = new ArrayList<>(goodsCategories.size());
        for (GoodsCategory goodsCategory : goodsCategories) {
            GoodsCategoryVo goodsCategoryVo = new GoodsCategoryVo();
            goodsCategoryVo.setId(goodsCategory.getId());
            goodsCategoryVo.setName(goodsCategory.getName());
            goodsCategoryVos.add(goodsCategoryVo);
        }
        return new RetResult<List<GoodsCategoryVo>>(200,"成功",goodsCategoryVos);
    }

    @Override
    public RetResult getCategoryById(Integer id) {
        return null;
    }
}
