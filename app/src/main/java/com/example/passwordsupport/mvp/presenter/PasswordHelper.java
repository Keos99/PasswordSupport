package com.example.passwordsupport.mvp.presenter;

import java.util.HashMap;
import java.util.Map;

public class PasswordHelper {

    private Map<String, String> dictionaries;

    PasswordHelper(){
        dictionaries = new HashMap<>();
    }

    public void dictionariesToMap(String[] russians, String[] latins){
        if (russians.length != latins.length) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < russians.length; i++) {
            dictionaries.put(russians[i], latins[i]);
        }
    }

    public String convertLatToRus(CharSequence source) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            String key = String.valueOf(Character.toLowerCase(c));

            if (dictionaries.containsKey(key)){
                result.append(Character.isUpperCase(c) ?
                        dictionaries.get(key).toUpperCase() : dictionaries.get(key));
            }

            if (result.length() <= i){
                result.append(c);
            }
        }
        return result.toString();
    }
}
