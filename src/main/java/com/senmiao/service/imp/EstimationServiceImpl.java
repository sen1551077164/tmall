package com.senmiao.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.senmiao.domain.Estimation;
import com.senmiao.domain.User;
import com.senmiao.domain.Vo.EstimationVo;
import com.senmiao.mapper.EstimationMapper;
import com.senmiao.mapper.UserMapper;
import com.senmiao.service.EstimationService;
import com.senmiao.util.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstimationServiceImpl implements EstimationService {
    @Autowired
    private EstimationMapper estimationMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据商品id获取商品的评价
     * @param id 商品id
     * @param page 页码数
     * @param size 每页的大小
     * @return
     */
    @Override
    public RetResult getEstimationByGoodsId(Integer id,Integer page,Integer size) {
        //分页
        size = size > 10? 10:size;
        PageHelper.startPage(page,size);
        //获取评论
        List<Estimation> estimations = estimationMapper.selectEstimationByGoodsId(id);
        ArrayList<EstimationVo> estimationVos = new ArrayList<>(estimations.size());
        estimations.forEach(e->{
            Integer userId = e.getUserId();
            User user =  userMapper.selectById(userId);

            EstimationVo estimationVo = new EstimationVo();
            estimationVo.setContent(e.getContent());
            estimationVo.setId(e.getId());
            estimationVo.setTime(e.getTime());
            estimationVo.setNickname(user.getNickname());
            estimationVos.add(estimationVo);

            //判断用户是否有匿名
            Integer anonymous = e.getAnonymous();
            if (anonymous != null && anonymous.equals(1)){
                //有匿名
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(user.getNickname().charAt(0));
                stringBuilder.append("***");
//                stringBuilder.append(user.getNickname().charAt(user.getNickname().length()-1));
                stringBuilder.append("(匿名)");
                estimationVo.setNickname(stringBuilder.toString());
            }
        });
        PageInfo<EstimationVo> estimationVoPageInfo = new PageInfo<>();
        estimationVoPageInfo.setList(estimationVos);
        return new RetResult<PageInfo<EstimationVo>>(200,"成功",estimationVoPageInfo);
    }
}
