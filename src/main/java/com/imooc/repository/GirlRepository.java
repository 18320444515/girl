package com.imooc.repository;

import com.imooc.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author tianyi
 * @date 2018-01-11 16:45
 */
//TODO 为什么< , >里面要这样写
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //【自己增加的方法】通过年龄查询
    public List<Girl> findByAge(Integer age);
}
