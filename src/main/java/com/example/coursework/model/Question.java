package com.example.coursework.model;

import java.util.Objects;

public class Question {
    private final Object question;
    private final Object answer;

    public Question(Object question, Object answer) {
        this.question = question;
        this.answer = answer;
    }

    public Object getQuestion() {
        return question;
    }

    public Object getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(answer, question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return "Задание " + question + ", ответ " + answer;
    }
}
