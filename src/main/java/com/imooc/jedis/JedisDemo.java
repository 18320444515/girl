package com.imooc.jedis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author tianyi
 * @date 2018-02-10 00:17
 */
@RestController
public class JedisDemo {

    @Value("${jedis.ip}")
    private String ip;

    @Value("${jedis.port}")
    private int port;


    /**
     * 单例测试
     */
    @GetMapping(value = "/jedisdemo1")
    public String demo1(){
        // 1.设置IP和端口
        Jedis jedis=new Jedis(ip, port);
        // 2.保存数据
        jedis.set("name","罗婧");
        // 3.获取数据
        String value=jedis.get("name");
        System.out.println(value);
        // 4.释放资源
        jedis.close();
        return value;
    }


    /**
     * 连接池方式连接
     */
    public void demo2(){
        // 获得连接池配置对象
        JedisPoolConfig config=new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(30);
        // 设置最大空闲连接数
        config.setMaxIdle(10);

        // 获得连接池
        JedisPool jedisPool=new JedisPool(config,ip,6379);

        // 获得核心对象
        Jedis jedis=null;
        try{
            // 通过连接至获得连接
            jedis = jedisPool.getResource();
            // 设置数据
            jedis.set("name","zty");
            // 获取数据
            String value=jedis.get("name");
            System.out.println(value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 释放资源
            if (jedis!=null){
                jedis.close();
            }
            if (jedisPool!=null){
                jedisPool.close();
            }
        }
    }
}
