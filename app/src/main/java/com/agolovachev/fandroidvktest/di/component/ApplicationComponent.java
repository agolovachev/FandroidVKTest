package com.agolovachev.fandroidvktest.di.component;

import com.agolovachev.fandroidvktest.di.module.ApplicationModule;
import com.agolovachev.fandroidvktest.di.module.ManagerModule;
import com.agolovachev.fandroidvktest.di.module.RestModule;
import com.agolovachev.fandroidvktest.ui.activity.BaseActivity;
import com.agolovachev.fandroidvktest.ui.activity.MainActivity;
import com.agolovachev.fandroidvktest.ui.fragment.NewsFeedFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    // activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    // fragments
    void inject(NewsFeedFragment fragment);
}
