package com.example.passwordsupport.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.passwordsupport.mvp.view.MainActivityView;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> {

    private PasswordHelper pHelper;
    private PasswordRandom pRandom;

    public MainActivityPresenter(){
        pHelper = new PasswordHelper();
        pRandom = new PasswordRandom();
    }

    public void pPrepareArraysOfAlphabet(String[] russians, String[] latins){
        pHelper.dictionariesToMap(russians, latins);
    }

    public void pPrepareArraysForPasswordRandom(String[] charcters, String[] specialCharacters) {
        pRandom.prepareArraysForGenerator(charcters, specialCharacters);
    }

    public String convert(CharSequence source) {
        return pHelper.convertLatToRus(source);
    }

    public int getQuality(CharSequence password) {
        return Math.min(password.length(), 10);
    }

    public void onClickGeneratePassword() {
        getViewState().prepareArraysForGenerator();
        getViewState().getCheckBoxStatus();
        getViewState().setRandomPassword(pRandom.generatePassword(8));
    }

    public void pGetCheckBoxStatus(boolean isUppercase, boolean isNumerals, boolean isSpecialCharacters) {
        pRandom.getCheckBoxStatus(isUppercase, isNumerals, isSpecialCharacters);
    }
}
