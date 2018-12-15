package com.dyc.callablePlusReflect.model;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:26
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:26
 * @Description:
 */
public class RoleDTO extends BaseDTO{

    private Integer id;
    private String name;

    public RoleDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleDTO() {
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
        return "RoleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
