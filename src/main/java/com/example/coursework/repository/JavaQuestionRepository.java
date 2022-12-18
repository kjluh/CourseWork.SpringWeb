package com.example.coursework.repository;

import com.example.coursework.model.Question;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private Set<Question> questionMap = new HashSet<>();


    @Override
    public Question add(Object question, Object answer) {
        Question quest = new Question(question, answer);
        questionMap.add(quest);
        return quest;
    }

    @Override
    public Question add(Question question) {
        questionMap.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionMap.remove(question);
        return question;
    }

    @Override
    public Set<Question> getAll() {
        return questionMap;
    }
}
