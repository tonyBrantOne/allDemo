package com.dyc.mqOnline.service;

import com.dyc.mqOnline.model.Player;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/9 19:46
 * @Description:
 */
public interface TestService {

    public Player testMqCapability(Integer id );

    void updateMqCapability( Player player );

    void updateMqCapabilityByPath(Player player);
}
