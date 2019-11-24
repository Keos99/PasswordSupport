package com.example.passwordsupport.mvp.view;

import com.arellomobile.mvp.MvpView;

public interface MainActivityView extends MvpView {

    void toastMakeText(int stringRes);

    void getCheckBoxStatus();

    void setRandomPassword(CharSequence charSequence);

    void prepareArraysForGenerator();

}
