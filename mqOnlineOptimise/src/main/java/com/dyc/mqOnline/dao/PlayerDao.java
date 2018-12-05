package com.dyc.mqOnline.dao;


import com.dyc.mqOnline.model.Player;

public interface PlayerDao {

    Player selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Player record);

    int updateByBath(Player player);


}