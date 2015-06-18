package com.example.rakatak.liquidrakatak.datalogic.user;

/**
 * Created by Robin on 14.06.2015.
 */
public class User {

    public String name, email, password;

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
