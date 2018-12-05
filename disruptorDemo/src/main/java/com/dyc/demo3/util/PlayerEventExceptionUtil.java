package com.dyc.demo3.util;

import com.dyc.demo3.model.Player;
import com.dyc.demo3.model.producer.Producer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/20 09:04
 * @Description:
 */
public class PlayerEventExceptionUtil {
    private static final Integer ERR_NUM_INIT = 1;

    public static void handleEventException(Throwable throwable, Player player){
        if(  ParamMapUtil.errNumMap.get(player.getId()) == null ){
            Map<String,Integer> playMap = new HashMap<String,Integer>();
            playMap.put("errNum",ERR_NUM_INIT);
            ParamMapUtil.errNumMap.put(player.getId(), playMap);
        }
        Integer errNum = ParamMapUtil.errNumMap.get(player.getId()).get("errNum");
        System.out.println( "player.getId()=="+player.getId() + "  errNum==="+errNum);
        if( errNum < 3){
            ParamMapUtil.errNumMap.get(player.getId()).put("errNum", ++errNum);
            Producer.getNewinstance().producerOrderMsg(player.getId());
        }else{
            System.out.println(throwable.getMessage());
        }
    }
}
