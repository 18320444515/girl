package com.imooc.domain;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author tianyi
 * @date 2018-01-11 15:45
 */
@Entity       //【通过@Entity创建数据库里的数据表】
public class Girl {

    @Id            //表示id列
    @GeneratedValue    //自增
    private Integer id;

    @NotBlank(message = "这个字段必传")
    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入门")
//    @NotNull
//    @Max()
//    @Length()
    private Integer age;

    @NotNull(message = "金额必传")
    private Double money;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
