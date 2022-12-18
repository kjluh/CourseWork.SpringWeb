package com.example.coursework.service;

import com.example.coursework.model.Question;
import com.example.coursework.repository.JavaQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(Object question, Object answer) {
        return javaQuestionRepository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Set<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int x = random.nextInt(javaQuestionRepository.getAll().size());
        List<Question> list = new ArrayList<>(javaQuestionRepository.getAll());
        return list.get(x);
    }
}
