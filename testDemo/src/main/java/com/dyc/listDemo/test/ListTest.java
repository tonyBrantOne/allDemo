package com.dyc.listDemo.test;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/19 12:04
 * @Description:
 */

import com.dyc.listDemo.model.Player;
import com.dyc.listDemo.model.UserBean;

import java.util.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/19 12:04
 * @Description:
 */
public class ListTest {

    public static void main(String[] args) {
        List<UserBean> list  = new ArrayList<>();
        Long num = 10L;
        Long playId = 11L;
        while ( true ){
            list.add(new UserBean( num--,"tony", playId++));
            if( list.size() == 10) break;;
        }
        System.out.println(list);
        List<Long> listId =  new ArrayList<>();
   //     list.forEach(n -> listId.add(n.getPlayId()));
        System.out.println(listId);
        System.out.println("");
        List<Player> playerList = new ListTest().new PlayerServiceImpl().selectListPlayerInPlayerId(listId);
        System.out.println(playerList);


        Collections.sort(list, new Comparator<UserBean>() {
            @Override
            public int compare(UserBean o1, UserBean o2) {
                if( o1.getId().intValue() < o2.getId().intValue() ) return -1;
                return 1;
            }
        });
        System.out.println("");
        System.out.println(list);
    }

    public void combineList(  List<UserBean> listBean,  List<Player> playerList){
        int num = 0;
//        Predicate<UserBean> contain1 = n -> null != n.getPlayId() ;
//        listBean.stream().filter(contain1).forEach(
//                n -> n.setPlayer(playerList.get(0))
//        );
        System.out.println(listBean);
    }

    public class PlayerServiceImpl{
        public List<Player> selectListPlayerInPlayerId(List<Long> listId){
            List<Player> lists = new ArrayList<>();
      //      listId.forEach( n -> lists.add( new Player(n.longValue(),"随机值"+(new Random().nextInt(10) + 10)) ));
            return lists;
        }
    }





}








