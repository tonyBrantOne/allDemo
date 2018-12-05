package com.dyc.model;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 19:58
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 19:58
 * @Description:
 */
public class User {
    private String name;
    private String passwaord;
    private Integer age;


    public User(String name, String passwaord, Integer age) {
        this.name = name;
        this.passwaord = passwaord;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswaord() {
        return passwaord;
    }

    public void setPasswaord(String passwaord) {
        this.passwaord = passwaord;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passwaord='" + passwaord + '\'' +
                ", age=" + age +
                '}';
    }
}
