package com.example.passwordsupport.mvp.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.example.passwordsupport.mvp.view.MainActivityView;

public class MainActivityPresenter extends MvpPresenter<MainActivityView> {

    private PasswordHelper pHelper;

    public MainActivityPresenter(){
        pHelper = new PasswordHelper();
    }

    public void pPrepareArraysOfAlphabet(String[] russians, String[] latins){
        pHelper.dictionariesToMap(russians, latins);
    }

    public String convert(CharSequence source) {
        return pHelper.convertLatToRus(source);
    }

    public int getQuality(CharSequence password) {
        return Math.min(password.length(), 10);
    }
}
