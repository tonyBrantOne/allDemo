package com.dyc.webSpringMvcProgram.model;

import java.util.ArrayList;
import java.util.List;

/**
 * title:
 * create by tony_jaa
 * date 2018/7/26
 */
public class Input {

    private String serviceId;
    private String method;
    private List<Object> body = new ArrayList<Object>();

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Object> getBody() {
        return body;
    }

    public void setBody(List<Object> body) {
        this.body = body;
    }
}
