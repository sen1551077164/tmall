package com.senmiao.util;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class MyPageInfo<T> {
    private PageInfo pageInfo;
    private List<T> list;
    public MyPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        pageInfo.setList(null);
    }
}
