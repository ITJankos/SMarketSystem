package com.houpu.domain;

import java.util.List;

/**
 * 通用分页对象
 * @param <E>
 */
public class PageBean<E> {
    private int totalCount;//从数据查询到的总记录数 select count(*) from user
    private int totalPage;//总页码 = 总数据%每页显示的记录条数 判断有余+1
    private List<E> list;//每页的数据
    private  int pageNum;//当前页码
    private int pageSize;//每页显示的记录数

    private Integer begin;
    private Integer end;

    private Integer buttonCount = 5;

    private void math(){
        if(this.totalPage<=this.buttonCount){
            this.begin=1;
            this.end=this.totalPage;
        }else {
            // 判断按钮基数偶数问题
            int pre=0;
            int nex=0;
            if( this.buttonCount%2==0){
                pre=this.buttonCount/2; //3
                // nex=this.buttonCount/2-1; //2
                nex=pre-1; //2
            }else {
                pre=this.buttonCount/2;
                nex=pre;
            }
            this.begin=this.pageNum-pre;
            this.end=this.pageNum+nex;
            // 特殊情况修正
            if(this.begin<=0){
                this.begin=1;
                this.end=this.buttonCount;
            }
            if(this.end>this.totalPage){
                this.end=this.totalPage;
                this.begin=this.totalPage -this.buttonCount+1;
            }
        }
    }

    public Integer getBegin() {
        math();
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getButtonCount() {
        return buttonCount;
    }

    public void setButtonCount(Integer buttonCount) {
        this.buttonCount = buttonCount;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", begin=" + begin +
                ", end=" + end +
                ", buttonCount=" + buttonCount +
                '}';
    }
}
