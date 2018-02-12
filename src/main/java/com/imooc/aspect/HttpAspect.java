package com.imooc.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;


/**
 * @author tianyi
 * @date 2018-01-11 21:46
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    //为了方便修改，这里一次性使用@Pointcut进行拦截，【这样在下面使用该拦截的时候只要用log()就行了】
    @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
    public void log(){
    }

    //这个@Before注解在方法执行之前就已经执行了，这里用于拦截方法，【并记录，记录是重点】
    //@Before("execution(public * com.imooc.controller.GirlController.*(..))")
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("22222");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object);
     // 在书写好异常处理之前，需要临时注释掉才能正常运行 /* 若开启这里,将会引发异常,大概是object==null,调用了null的toString()方法 */TODO 原理思路欠
    }
}

