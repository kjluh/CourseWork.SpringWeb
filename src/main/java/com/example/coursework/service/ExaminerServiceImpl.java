package com.example.coursework.service;

import com.example.coursework.model.Question;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;


    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int size) {
        HashSet<Question> questions = new HashSet<>(1);
        if (size > javaQuestionService.getAll().size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Запрошено слишком большое количество элементов, " +
                    "максимальное: " + javaQuestionService.getAll().size());
        }
        while (questions.size() < size) {
            questions.add(javaQuestionService.getRandomQuestion());
        }
        return questions;
    }

}
