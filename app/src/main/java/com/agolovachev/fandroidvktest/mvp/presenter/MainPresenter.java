package com.agolovachev.fandroidvktest.mvp.presenter;

import com.agolovachev.fandroidvktest.CurrentUser;
import com.agolovachev.fandroidvktest.mvp.view.MainView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public void checkAuth() {
        if (!CurrentUser.isAuthorized()) {
            getViewState().startSignIn();
        } else {
            getViewState().signedIn();
        }
    }
}
