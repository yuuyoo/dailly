package com.djl.ssh.daily.vo;

import lombok.Data;

import java.util.List;

/**
 * @author DJL
 * @create 2019-07-03 11:09
 * @desc 分页信息类
 **/
@Data
public class PageBean <T> {

    // 状态码 0 正常
    private int code;
    // 状态信息
    private String msg;
    // 查询的数据条数
    private int count;
    // 查询的数据内容集合
    public List<T> data;

    /**
     * 静态方法返回pageBean对象
     * @param count
     * @param data
     * @param <T>
     * @return
     */
    public static <T> PageBean<T> setOK(int count, List<T> data) {
        PageBean<T> pageBean = new PageBean<>();
        pageBean.setCode(0);
        pageBean.setMsg("OK");
        pageBean.setCount(count);
        pageBean.setData(data);
        return pageBean;
    }

}
