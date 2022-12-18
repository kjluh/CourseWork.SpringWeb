package com.example.coursework.service;

import com.example.coursework.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    JavaQuestionService javaQuestionService;
    @Mock
    MathQuestionService mathQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    private HashSet<Question> testArr = new HashSet<>();
    Question q1 = new Question("test1", "test11");
    Question q2 = new Question("test2", "test12");


    @Test
    public void getQuestions() {
        testArr.add(q1);
        testArr.add(q2);
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(q1);
        Mockito.when(mathQuestionService.getRandomQuestion()).thenReturn(q2);
        Mockito.when(javaQuestionService.getAll()).thenReturn(testArr);
        Assertions.assertEquals(examinerService.getQuestions(2), testArr);
    }

    @Test
    public void getQuestionsException() {
        Assertions.assertThrows(ResponseStatusException.class, () -> examinerService.getQuestions(3));
    }
}
