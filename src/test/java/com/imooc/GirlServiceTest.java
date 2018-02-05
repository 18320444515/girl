package com.imooc;

import com.imooc.domain.Girl;
import com.imooc.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tianyi
 * @date 2018-01-12 15:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

/*    //@Test
    public void findOneTest(){
        Girl girl=girlService.findOne(1);
        //断言 age==18
        //【若错误，会有期望与实际的区别显示出来】
        Assert.assertEquals(new Integer(18),girl.getAge());
    }*/
}
