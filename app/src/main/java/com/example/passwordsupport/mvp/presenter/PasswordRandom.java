package com.example.passwordsupport.mvp.presenter;

import com.example.passwordsupport.mvp.presenter.generators.GeneratorsBuilder;
import com.example.passwordsupport.mvp.presenter.generators.IGenerator;

import java.util.List;
import java.util.Random;

class PasswordRandom {

    private Random random;
    private GeneratorsBuilder generatorsBuilder;

    PasswordRandom() {
        random = new Random();
        generatorsBuilder = new GeneratorsBuilder();
    }

    void prepareArraysForGenerator(String[] characters, String[] specialCharacters) {
        generatorsBuilder.getArrays(characters, specialCharacters);
    }

    void getCheckBoxStatus(boolean isUppercase, boolean isNumerals, boolean isSpecialCharacters) {
        generatorsBuilder.getCheckBoxStatus(isUppercase, isNumerals, isSpecialCharacters);
    }

    String generatePassword(int numberOfDigits) {
        StringBuilder randomPassword = new StringBuilder();
        List<IGenerator> generators = generatorsBuilder.getGenerator();

        for (int i = 0; i < numberOfDigits; i++) {
            randomPassword.append(generators.get(random.nextInt(generators.size())).generate());
        }
        return randomPassword.toString();
    }

}
