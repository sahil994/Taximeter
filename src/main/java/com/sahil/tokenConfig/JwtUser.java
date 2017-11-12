package com.sahil.tokenConfig;

public class JwtUser {



    public String userName;

    public String getUserName() {
        return userName;
    }

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public long id;
    String role;

    public void setId(long id) {
        this.id = id;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
