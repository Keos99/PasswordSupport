package com.example.passwordsupport.mvp.presenter.generators;

import java.util.Random;

public class NumeralsGenerator implements IGenerator {

    private Random random;

    public NumeralsGenerator() {
        this.random = new Random();
    }

    @Override
    public String generate() {
        return Integer.toString(random.nextInt(10));
    }
}
