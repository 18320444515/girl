package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tianyi
 * @date 2018-01-11 17:18
 */
@Service
public class GirlService {          //【体现安全性】

    @Autowired
    private GirlRepository girlRepository;

    @Transactional//加了"事务"@Transactional后，若其中有数据插入失败，则将都报错，没有一条会成功
    //【延伸】除了查询不需要加"事务"@Transactional，为安全起见，其他都要加
    public void insertTwo(){
        Girl girlA=new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB=new Girl();
        girlB.setAge(19);
        girlB.setCupSize("BBBB");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{    //【通过抛出异常，使得特殊情况可以在另外一个专门的地方得到统一处理】
        Girl girl = girlRepository.findOne(id);         //【而且，因为Exception太多杂质，为了得到匹配与结果模板的内容，
                                                       // 我们定义了一个自己的异常GirlExecption】
        Integer age = girl.getAge();
        if (age < 10) {
            //返回"你还在上小学吧" code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);   //若直接外抛Exception，则将会改变code等多项内容，此时需要一个特制的GirlException
        }else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);    //补充：在外抛异常的时候顺便构造创建含有对应枚举的GirlException
        }

        //如果>16岁,加钱
        //...
    }
}
