package com.example.passwordsupport.mvp.presenter.generators;

import java.util.ArrayList;
import java.util.List;

public class GeneratorsBuilder {

    private String[] characters;
    private String[] specialCharacters;
    private boolean isUppercase;
    private boolean isNumerals;
    private boolean isSpecialCharacters;

    public void getArrays(String[] characters, String[] specialCharacters) {
        this.characters = characters;
        this.specialCharacters = specialCharacters;
    }

    public void getCheckBoxStatus(boolean isUppercase, boolean isNumerals, boolean isSpecialCharacters) {
        this.isUppercase = isUppercase;
        this.isNumerals = isNumerals;
        this.isSpecialCharacters = isSpecialCharacters;
    }

    public List<IGenerator> getGenerator() {
        List<IGenerator> generators = new ArrayList<>();

        generators.add(new CharGenerator(characters, isUppercase));
        if (isNumerals) {
            generators.add(new NumeralsGenerator());
        }
        if (isSpecialCharacters) {
            generators.add(new SpecialCharactersGenerator(specialCharacters));
        }

        return generators;
    }
}
