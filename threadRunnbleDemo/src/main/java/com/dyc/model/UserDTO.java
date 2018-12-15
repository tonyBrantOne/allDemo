package com.dyc.model;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 19:30
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 19:30
 * @Description:
 */
public class UserDTO {
    private Integer id;
    private String name;

    public UserDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserDTO(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



}
