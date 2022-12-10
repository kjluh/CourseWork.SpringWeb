package com.example.coursework.service;

import com.example.coursework.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    JavaQuestionService javaQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    private HashSet<Question> example = new HashSet<>();
    Question q1 = new Question("test1", "test11");
    Question q2 = new Question("test2", "test12");

    @BeforeEach
    public void setUp() {
        example.add(q1);
        example.add(q2);
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(q1, q2);
        Mockito.when(javaQuestionService.getAll()).thenReturn(example);
    }

    @Test
    public void getQuestions() {
        Assertions.assertEquals(examinerService.getQuestions(2), example);
    }
}
