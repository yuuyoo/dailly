package com.djl.ssh.daily.vo;

import lombok.Data;

/**
 * @author DJL
 * @create 2019-07-03 11:09
 * @desc 返回Json对象
 **/
@Data
public class R {

    // 状态码 200 成功，400失败
    private int code;
    // 数据对象
    private Object data;

    // 成功返回
    public static R setOK(Object obj) {
        R r = new R();
        r.setCode(200);
        r.setData(obj);
        return r;
    }

    // 失败返回
    public static R setERROR(Object obj) {
        R r = new R();
        r.setCode(400);
        r.setData(obj);
        return r;
    }

    // 指定参数返回
    public static R exec(boolean isSuccess, Object obj) {
        return isSuccess ? setOK(obj) : setERROR(obj);
    }
}
