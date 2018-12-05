package com.dyc.model;/**
 * @Auther: tony_jaa
 * @Date: 2018/11/5 16:19
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2018/11/5 16:19
 * @Description:
 */
public class Order {

    private Integer id;
    private String name;
    private Integer status;

    public Order(Integer id, String name, Integer status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Order() {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
