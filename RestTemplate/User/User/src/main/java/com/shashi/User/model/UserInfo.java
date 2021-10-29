package com.shashi.User.model;

public class UserInfo {
    private int id;
    private String username;
    private int salary;



    public UserInfo(int id, String username, int salary) {
        this.id = id;
        this.username = username;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
