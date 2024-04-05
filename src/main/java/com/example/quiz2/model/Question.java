package com.example.quiz2.model;

public class Question {
    private int id;
    private String text;
    private String category;
    private String correctAnswer;
    private String answerOption_1;
    private String answerOption_2;
    private String answerOption_3;
    private String answerOption_4;
    private int quizId;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getCategory() {
        return category;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getAnswerOption_1() {
        return answerOption_1;
    }

    public String getAnswerOption_2() {
        return answerOption_2;
    }

    public String getAnswerOption_3() {
        return answerOption_3;
    }

    public String getAnswerOption_4() {
        return answerOption_4;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setAnswerOption_1(String answerOption_1) {
        this.answerOption_1 = answerOption_1;
    }

    public void setAnswerOption_2(String answerOption_2) {
        this.answerOption_2 = answerOption_2;
    }

    public void setAnswerOption_3(String answerOption_3) {
        this.answerOption_3 = answerOption_3;
    }

    public void setAnswerOption_4(String answerOption_4) {
        this.answerOption_4 = answerOption_4;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }
}
