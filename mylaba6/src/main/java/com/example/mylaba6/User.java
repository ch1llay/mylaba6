package com.example.mylaba6;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;
import java.util.HashMap;

@JsonAutoDetect
class User {
    public String nickname;
    public String userLogin;
    public String password;
    public String role;

    public String getNickname(){
        return nickname;
    }
    public String getLogin(){
        return userLogin;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }

    public User() {
        role = "user";
    }
}

@JsonAutoDetect
class Users {
    public HashMap<String, User> users;

    public Users() {
        users = new HashMap<>();
    }
}
