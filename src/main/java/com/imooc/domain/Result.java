package com.imooc.domain;

/**
 * http请求返回的最外层对象
 * @author tianyi
 * @date 2018-01-11 22:27
 */
public class Result<T> {      //【把返回的格式给固定好了，无论是成功还是异常皆适用】
    /* 错误码 */
    private Integer code;

    /* 提示信息 */
    private String msg;

    /* 提示的具体内容 【若空，则空；但若非空，则可以显示整个Girl对象的toString()】*/
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
