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
public class UserDTO extends BaseDTO{
    private Integer id;
    private int card;
    private Long num;
    private long hegiht;
    private String name;
    private Boolean age;
    private boolean sex;

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

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public long getHegiht() {
        return hegiht;
    }

    public void setHegiht(long hegiht) {
        this.hegiht = hegiht;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", card=" + card +
                ", num=" + num +
                ", hegiht=" + hegiht +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
