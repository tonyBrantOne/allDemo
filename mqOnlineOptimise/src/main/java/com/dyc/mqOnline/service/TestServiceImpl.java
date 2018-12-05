package com.dyc.mqOnline.service;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/9 19:47
 * @Description:
 */

import com.dyc.mqOnline.dao.PlayerDao;
import com.dyc.mqOnline.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/9 19:47
 * @Description:
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    PlayerDao playerDao;

    @Override
    public Player testMqCapability( Integer id ) {
        Player player = playerDao.selectByPrimaryKey(id);
        return player;
    }

    @Override
    public void updateMqCapability( Player player ) {
        playerDao.updateByPrimaryKeySelective(player);
    }

    /**
     * 批量添加
     * @param player
     */
    @Override
    public void updateMqCapabilityByPath(Player player) {
        playerDao.updateByBath(player);
    }

}
