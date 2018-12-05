package com.dyc.model;/**
 * @Auther: tony_jaa
 * @Date: 2018/11/28 19:31
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2018/11/28 19:31
 * @Description:
 */
public class UserDTO {
    private Integer id;
    private String name;
    private Boolean age;

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

    public Boolean getAge() {
        return age;
    }

    public void setAge(Boolean age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
