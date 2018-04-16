package com.agolovachev.fandroidvktest.mvp.view;

import com.arellomobile.mvp.MvpView;

public interface MainView extends MvpView {
    void startSignIn();
    void signedIn();
}
