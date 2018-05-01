package com.zzy.po;

import java.util.Date;

/**
 * Created by stt on 2018/4/30.
 */
public class User extends BasePo{

    private String userUuid;
    private String name;
    private String password;
    private Integer type;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
