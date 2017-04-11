package com.yaojiafeng.web.core;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/5/16 下午6:30 $
 */
public class Response {
    private int code;

    private String msg;

    private Object info;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
