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

    private boolean answered;

    public Question() {
    }

    public Question(String text, boolean answer, boolean answered) {
        this.text = text;
        this.answer = answer;
        this.answered = answered;
    }

    public String getText() {
        return text;
    }

    public boolean isAnswer() {
        return answer;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }
}
