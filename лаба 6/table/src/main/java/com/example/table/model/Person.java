package com.example.table.model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Person {

    public int id;
    public String userName;
    public String email;
    public boolean active;

    public Person(int id, String userName, String email, boolean active) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

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

    @Override
    public String toString() {
        return id + " "
                + userName + " "
                + email + " ";
    }
    public String toJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(this);
    }
}