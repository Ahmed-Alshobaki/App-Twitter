package com.example.app_twitter.users;

public class user {
    int id;
    String name ;
    String username ;
    String Email;
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public user(String name, String username, String email, String password) {

        this.name = name;
        this.username = username;
        Email = email;
        this.password = password;
    }
    public user() {


    }


}
