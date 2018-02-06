package com.imooc.repository;

import com.imooc.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author tianyi
 * @date 2018-01-11 16:45
 */
//【通过继承JPA(ctrl点进去可以看具体某方法的返回类型)，可以获得满足基本的GET、POST需求，若不足，可自己加方法】
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //【自己增加的方法】通过年龄查询
    public List<Girl> findByAge(Integer age);  //写的时候也必须按照格式来写才可以自动生成查询
}
