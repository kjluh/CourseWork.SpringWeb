package com.example.coursework.service;

import com.example.coursework.model.Question;
import com.example.coursework.repository.MathQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(Object question, Object answer) {
        return mathQuestionRepository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int x = random.nextInt(mathQuestionRepository.getAll().size());
        List<Question> list = new ArrayList<>(mathQuestionRepository.getAll());
        return list.get(x);
    }
}
