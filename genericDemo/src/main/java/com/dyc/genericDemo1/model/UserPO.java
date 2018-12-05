package com.dyc.genericDemo1.model;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 13:29
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 13:29
 * @Description:
 */
public class UserPO extends AbstractBasePO {
    private String userName;
    private String password;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
