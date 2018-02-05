package com.imooc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * @author tianyi
 * @date 2018-01-12 15:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc                 //测试Controller时要加上这个注解
public class GirlControllerTest {

    @Autowired
    private MockMvc mvc;             //测试Controller时要用这个类MockMvc

    @Test
    public void girlList() throws Exception {                        //【注意：前面url若报错后面不会再测试】
        mvc.perform(MockMvcRequestBuilders.get("/girls"))      //url
                .andExpect(MockMvcResultMatchers.status().isOk())                //是否正常返回200
        .andExpect(MockMvcResultMatchers.content().string("abc"));  //返回内容是否如愿
    }

}