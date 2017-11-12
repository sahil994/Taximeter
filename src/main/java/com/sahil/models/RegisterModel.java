package com.sahil.models;

import javax.persistence.*;

@Entity
@Table(name = "RegisterUsers")
public class RegisterModel {


    @Column(name = "username")
    public String userName;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
