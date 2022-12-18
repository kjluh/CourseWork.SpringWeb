package com.example.coursework.service;

import com.example.coursework.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(Object question, Object answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
