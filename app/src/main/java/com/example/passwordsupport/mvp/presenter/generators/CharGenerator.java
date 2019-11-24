package com.example.passwordsupport.mvp.presenter.generators;

import java.util.Random;

public class CharGenerator implements IGenerator {

    private boolean isUppercase;
    private String[] characters;
    private Random random;

    public CharGenerator(String[] characters, boolean isUppercase) {
        this.isUppercase = isUppercase;
        this.characters = characters;
        random = new Random();
    }

    @Override
    public String generate() {
        String answer = characters[random.nextInt(characters.length - 1)];
        if (isUppercase && random.nextBoolean()) {
            return answer.toUpperCase();
        } else {
            return answer;
        }
    }
}
