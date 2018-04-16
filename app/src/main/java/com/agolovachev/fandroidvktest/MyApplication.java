package com.agolovachev.fandroidvktest;

import android.app.Application;

import com.agolovachev.fandroidvktest.di.component.ApplicationComponent;
import com.agolovachev.fandroidvktest.di.component.DaggerApplicationComponent;
import com.agolovachev.fandroidvktest.di.module.ApplicationModule;
import com.vk.sdk.VKSdk;

public class MyApplication extends Application {

    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();

        VKSdk.initialize(this);
    }

    private void initComponent() {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
