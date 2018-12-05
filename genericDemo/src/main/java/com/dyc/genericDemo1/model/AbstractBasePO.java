package com.dyc.genericDemo1.model;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 13:29
 * @Description:
 */

import java.sql.Timestamp;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 13:29
 * @Description:
 */
public abstract class AbstractBasePO {
    private Long state;
    private Integer createId;
    private Timestamp createTime;

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
