package com.dyc.demo3.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:31
 * @Description:
 */
public class Player {
    private static final long serialVersionUID = 1L;
    private  Boolean isFlag = true;


    public Player() {
    }

    public Player(Long id) {
        this.id = id;
    }

    private Long id;//玩家编号

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(Boolean isFlag) {
        this.isFlag = isFlag;
    }
}
