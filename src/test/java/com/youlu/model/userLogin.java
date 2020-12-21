package com.youlu.model;

import java.util.HashMap;
import java.util.Map;

public class userLogin {
    private Map<String,Object> apis = new HashMap<>();
    private String ctype;

    public Map<String, Object> getMap() {
        return apis;
    }

    public void setMap(Map<String, Object> apis) {
        this.apis = apis;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
}