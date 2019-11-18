package com.example.passwordsupport.ui;

import android.app.Application;

public class App extends Application {
    public static App instance;

    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance(){
        return instance;
    }
}
