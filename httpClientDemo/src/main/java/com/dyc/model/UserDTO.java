package com.dyc.model;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/27 14:49
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/27 14:49
 * @Description:
 */
public class UserDTO {
    private String userName;
    private String nickName;
    private String password;

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
