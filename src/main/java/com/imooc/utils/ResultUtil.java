package com.imooc.utils;

import com.imooc.domain.Result;

/**
 * “廖师兄名言：代码优化千万不要等到以后再做！”
 * @author tianyi
 * @date 2018-01-11 22:33
 */
public class ResultUtil {
    /* static静态方法可以不用new即可使用，妙 */

    public static Result success(Object object){   //【此类的创造目的在于减少重复的代码】
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);//代码简化！妙也！
    }

    public static Result error(Integer code, String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
