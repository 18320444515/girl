package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tianyi
 * @date 2018-01-11 13:29
 */
//@Controller  【前后端分离不推荐】若仅用controller，则需要a.pom引入thymeleaf依赖  b.return “具体的(html)文件名”如"index"（与web jsp那些有相似）
@RestController //@RestController = @Controller + @ResponseBody


@RequestMapping(value ="/hello")
public class HelloController {             //【各基础知识】

    @Autowired
    private GirlProperties girlProperties;//通过对象获取配置信息

    //@RequestMapping(value = {"/hello" , "/hi"})  写成一个集合就可以两个选择来访问了

    //若写了method 写了POST则不可GET访问(将405，需要借助postman用POST访问)  若不写 method 则既可以GET又可以POST，但安全起见不推荐。

    //可以通过在参数列表中加 @PathVariable("id")Integer id 来获取url的参数值

    //@RequestParam 与@PathVariable("id")不同的是，前者必须通过 ?id=153 才能获取参数值
    //              且前者可以添加更多属性设置，如是否必传、默认值等
    @RequestMapping(value = "/say", method = RequestMethod.GET)
    //也可以用@GetMapping、@PostMapping来代替@RequestMapping，可以少些一些代码
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0")Integer myId){
        return girlProperties.getCupSize()+myId;
    }
}
