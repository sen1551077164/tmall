package com.senmiao.util;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class MyPageInfo<T> {
    private static final long serialVersionUID = 1L;
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //当前页的数量
    private int size;
    //当前页面第一个元素在数据库中的行号
    private int startRow;
    //当前页面最后一个元素在数据库中的行号
    private int endRow;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;

    //前一页
    private int prePage;
    //下一页
    private int nextPage;

    //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;
    //是否有前一页
    private boolean hasPreviousPage = false;
    //是否有下一页
    private boolean hasNextPage = false;
    //导航页码数
    private int navigatePages;
    //所有导航页号
    private int[] navigatepageNums;
    //导航条上的第一页
    private int navigateFirstPage;
    //导航条上的最后一页
    private int navigateLastPage;

    public MyPageInfo(PageInfo pageInfo) {
        this.pageNum = pageInfo.getPageNum();
        //pageSize,size,startRow,endRow,total,pages,list,prePage,
        // nextPage,isFirstPage,isLastPage,hasPreviousPage,hasNextPage,
        // navigatePages,navigatepageNums,navigateFirstPage,navigateLastPage
        this.pageSize = pageInfo.getPageSize();
        this.size = pageInfo.getSize();
        this.startRow = pageInfo.getStartRow();
        this.endRow = pageInfo.getEndRow();
        this.total = pageInfo.getTotal();
        this.pages = pageInfo.getPages();
//        this.list = pageInfo.getList();
        this.prePage = pageInfo.getPrePage();
        this.nextPage = pageInfo.getNextPage();
        this.isFirstPage = pageInfo.isIsFirstPage();
        this.isLastPage = pageInfo.isIsLastPage();
        this.hasPreviousPage = pageInfo.isHasPreviousPage();
        this.hasNextPage = pageInfo.isHasNextPage();
        this.navigatePages = pageInfo.getNavigatePages();
        this.navigatepageNums = pageInfo.getNavigatepageNums();
        this.navigateFirstPage = pageInfo.getNavigateFirstPage();
        this.navigateLastPage = pageInfo.getNavigateLastPage();
    }
}
