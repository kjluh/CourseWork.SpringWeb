package com.example.coursework.repository;

import com.example.coursework.model.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private Set<Question> mathSet = new HashSet<>();

    @Override
    public Question add(Object question, Object answer) {
        Question example = new Question(question, answer);
        mathSet.add(example);
        return example;
    }

    @Override
    public Question add(Question question) {
        mathSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        mathSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return mathSet;
    }
}
