package com.example.passwordsupport.mvp.presenter.generators;

import java.util.Random;

public class SpecialCharactersGenerator implements IGenerator {

    private String[] specialCharacters;
    private Random random;

    public SpecialCharactersGenerator(String[] specialCharacters) {
        this.specialCharacters = specialCharacters;
        random = new Random();
    }

    @Override
    public String generate() {
        return specialCharacters[random.nextInt(specialCharacters.length - 1)];
    }
}
