package com.example.lurenman.databaseupgradedemo.entitys;

/**
 * @author: baiyang.
 * Created on 2018/1/25.
 */

public class UserEntity {
    private String userName;
    private String userSex;
    private int userAge;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
