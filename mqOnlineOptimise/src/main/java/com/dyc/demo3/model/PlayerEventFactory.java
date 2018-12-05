package com.dyc.demo3.model;

import com.dyc.mqOnline.model.Player;
import com.lmax.disruptor.EventFactory;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:34
 * @Description:
 */
public class PlayerEventFactory implements EventFactory<Player> {


    @Override
    public Player newInstance() {
        return new Player();
    }
}
