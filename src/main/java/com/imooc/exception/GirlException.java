package com.imooc.exception;

import com.imooc.enums.ResultEnum;
/**
 * @author tianyi
 * @date 2018-01-11 23:02
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
