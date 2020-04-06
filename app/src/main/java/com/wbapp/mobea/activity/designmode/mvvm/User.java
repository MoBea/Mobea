package com.wbapp.mobea.activity.designmode.mvvm;

/**
 * Create by MoBea on 2020/4/6
 */
public class User {
    public String name;
    public String phoneNumber;

    public User(String name,String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
