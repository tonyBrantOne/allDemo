package com.dyc.listDemo.model;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/19 12:05
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/19 12:05
 * @Description:
 */
public class UserBean {
    private Long id;
    private String name;
    private Long playId;
    private Player player;




    public UserBean(Long id, String name, Long playId) {
        this.id = id;
        this.name = name;
        this.playId = playId;
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

    public Long getPlayId() {
        return playId;
    }

    public void setPlayId(Long playId) {
        this.playId = playId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playId=" + playId +
                ", player=" + player +
                '}';
    }
}
