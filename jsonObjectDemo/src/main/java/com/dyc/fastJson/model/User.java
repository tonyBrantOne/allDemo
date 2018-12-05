package com.dyc.fastJson.model;

/**
 * @Auther: tony_jaa
 * @Date: 2018/8/22 16:06
 * @Description:
 */
public class User {

    private String userName;
    private Long age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public User(String userName, Long age) {
        this.userName = userName;
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {
    }
}
