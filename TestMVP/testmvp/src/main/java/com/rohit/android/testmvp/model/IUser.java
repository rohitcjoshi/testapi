package com.rohit.android.testmvp.model;

public interface IUser {
    String getEmailID();
    String getPassword();
    boolean isValidEmail();
    boolean isValidPassword();
    int isValidData();
}
