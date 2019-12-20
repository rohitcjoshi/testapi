package com.rohit.android.testmvp.view;

public interface ILoginView {
    void onLoginSuccess(String message);
    void onLoginError(String errorMessage);
}
