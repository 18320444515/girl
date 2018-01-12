package com.imooc.enums;

/**
 * @author tianyi
 * @date 2018-01-11 23:03
 */
/* Enum价值：可以统一管理异常以及对应的code，方便管理修改且不容易重复 */
public enum ResultEnum {    //【统一管理枚举的类】
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),
    PRIMARY_SCHOOL(100, "我猜你可能还在上小学"),  /**【枚举大概是把两个参数的圆括号集合定义出来，
                                                    *像常量那样调用（估计一般会在某方法的参数的位置那里被调用吧）】
                                                    * 直接用枚举的大写字母字串即可 */

    ;  //注意这里是分号，前面是逗号    TODO 欠枚举的掌握——ACM

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {        //在构造创建的时候同时set重要属性
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }  //枚举Enum一般不需要setter方法，其在构造方法执行的时候就已经set了

    public String getMsg() {
        return msg;
    }
}