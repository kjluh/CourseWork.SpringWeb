package com.example.coursework.service;

import com.example.coursework.model.Question;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;


    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int quantityQuestions) {
        HashSet<Question> questions = new HashSet<>();
        if (quantityQuestions > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Запрошено слишком большое количество элементов, " +
                    "максимальное: " + javaQuestionService.getAll().size());
        }
        Random random = new Random();
        int javaQuestions = random.nextInt(quantityQuestions); // выпало 20 вопросов, всего запросили 25
        int mathQuestion = quantityQuestions - javaQuestions; //  для математики осталось  5 значит для джавы 20
        while (mathQuestion > questions.size()) {
            questions.add(mathQuestionService.getRandomQuestion());
        }
        while (quantityQuestions > questions.size()) {
            questions.add(javaQuestionService.getRandomQuestion());
        }
        return questions;
    }

}
