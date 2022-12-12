package com.example.coursework.service;

import com.example.coursework.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> questionMap = new HashSet<>();


    @Override
    public Question add(String question, String answer) {
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

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int x = random.nextInt(questionMap.size());
        List<Question> list = new ArrayList<>(questionMap);
        return list.get(x);
    }
}
