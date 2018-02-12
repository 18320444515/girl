package com.imooc.exception;

import com.imooc.enums.ResultEnum;
/**
 * @author tianyi
 * @date 2018-01-11 23:02
 */
public class GirlException extends RuntimeException{  //【!!!注意这里要用RuntimeException，不然普通Exception不能进行事务回滚】

    private Integer code;

    public GirlException(ResultEnum resultEnum) {     //构造方法，传入枚举类
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
