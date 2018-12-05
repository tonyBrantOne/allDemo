package com.dyc.listDemo.model;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/19 12:53
 * @Description:
 */

import java.util.Date;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/19 12:53
 * @Description:
 */
public class Player {

    private Long id;
    private String name;
    private Date createTime;

    public Player(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player(Long id, String name, Date createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
