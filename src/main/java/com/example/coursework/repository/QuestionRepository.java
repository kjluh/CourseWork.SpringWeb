package com.example.coursework.repository;

import com.example.coursework.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Object question, Object answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
