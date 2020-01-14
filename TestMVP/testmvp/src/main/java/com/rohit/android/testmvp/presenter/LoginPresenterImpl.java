package com.rohit.android.testmvp.presenter;

import android.widget.Toast;

import com.rohit.android.testmvp.model.User;
import com.rohit.android.testmvp.view.ILoginView;

import es.dmoral.toasty.Toasty;

public final class LoginPresenterImpl implements ILoginPresenter {
    private ILoginView loginView;
    private int count = 0;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String emailId, String password) {
        final User user = new User(emailId, password);
        int resultCode = user.isValidData();
        if(resultCode == 0) {
            loginView.onLoginSuccess("Login successful..!");
        } else {
            String errorMessage = "Login failed..!";
            switch (resultCode) {
                case 1:
                    errorMessage = "Email cannot be empty..!";
                    break;
                case 2:
                    errorMessage = "Please enter valid email id..!";
                    break;
                case 3:
                    errorMessage = "Please enter valid password..!";
                    break;
            }
            loginView.onLoginError(errorMessage);
        }
    }

    public int calculateSomething() {
        return ++count;
    }
}
