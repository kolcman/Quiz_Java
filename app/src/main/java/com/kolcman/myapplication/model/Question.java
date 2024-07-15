package com.kolcman.myapplication.model;

/**
 * Class model
 * Author Max
 * version 1.0
 * date 13.07.24
 */

public class Question {

    private String text;
    private boolean answer;

    public Question() {
    }

    public Question(String text, boolean answer) {
        this.text = text;
        this.answer = answer;
    }

    public String getText() {
        return text;
    }

    public boolean isAnswer() {
        return answer;
    }
}
