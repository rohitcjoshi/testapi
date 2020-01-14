package com.rohit.android.testmvp.presenter;

import com.rohit.android.testmvp.view.IHomeView;

public final class HomePresenterImpl implements IHomePresenter {
    private IHomeView homeView;

    public HomePresenterImpl(IHomeView homeView) {
        this.homeView = homeView;
    }

    @Override
    public void onButtonClick() {
        homeView.updateText();
    }
}
