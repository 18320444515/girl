package com.imooc.handle;

import com.imooc.domain.Result;
import com.imooc.exception.GirlException;
import com.imooc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tianyi
 * @date 2018-01-11 23:01
 */
@ControllerAdvice
public class ExceptionHandle {          //【统一捕获并处理异常的类】

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class) //捕获Exception异常吗？触发下面的操作?
    @ResponseBody  //TODO 这个注解有什么用？
    public Result handle(Exception e) {
        //result = object instanceof class  判断object是否为class的或者其子类的实例
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;  //建议建立一个自己的异常
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);  //因为未知错误异常难以排查，此时需要通过日志把异常(控制台)打印出来,以便排查
            return ResultUtil.error(-1, "未知错误");
        }
    }
}