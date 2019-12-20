package com.rohit.android.testmvp.model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public final class User implements IUser {
    private String emailId;
    private String password;

    public User(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public String getEmailID() {
        return emailId;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isValidEmail() {
        return (!TextUtils.isEmpty(emailId) && Patterns.EMAIL_ADDRESS.matcher(emailId).matches());
    }

    @Override
    public boolean isValidPassword() {
        return (!TextUtils.isEmpty(password) && password.length() > 4);
    }

    @Override
    public int isValidData() {
        // 1. email empty
        // 2. email not valid
        // 3. password not valid
        if (TextUtils.isEmpty(emailId)) {
            return 1;
        } else if(!isValidEmail()) {
            return 2;
        } else if(!isValidPassword()) {
            return 3;
        }
        return 0; // success
    }
}
