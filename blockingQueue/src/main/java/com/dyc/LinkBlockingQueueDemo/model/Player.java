package com.dyc.LinkBlockingQueueDemo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Player implements Cloneable{
    private Integer id;

    private String nickName;

    private Integer online;

    private Date lastLoginTime;

    private Date lastTime;

    private List<Player> listPlayer = new ArrayList<Player>();

    public Player() {
    }

    public Player(Integer id, Integer online) {
        this.id = id;
        this.online = online;
    }

    public Player(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public List<Player> getListPlayer() {
        return listPlayer;
    }

    public void setListPlayer(List<Player> listPlayer) {
        this.listPlayer = listPlayer;
    }

    @Override
    public Player clone() throws CloneNotSupportedException {
        return (Player) super.clone();
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                '}';
    }
}