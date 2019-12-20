package com.rohit.android.testmvp.presenter;

import com.rohit.android.testmvp.model.IUser;

public interface ILoginPresenter {
    void onLogin(String emailId, String password);
}
