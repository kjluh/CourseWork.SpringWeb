package com.example.coursework.service;

import com.example.coursework.model.Question;
import com.example.coursework.repository.MathQuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Mock
    MathQuestionRepository mathQuestionRepository;
    @InjectMocks
    MathQuestionService mathQuestionService;
    private Set<Question> questionMapTest = new HashSet<>();
    Question q1 = new Question(1,2);
    Question q2 = new Question(3,4);
    Question q3 = new Question(5,6);
    @BeforeEach
    public void set(){
        Mockito.when(mathQuestionRepository.getAll()).thenReturn(questionMapTest);
    }

    @Test
    public void addObject(){
        questionMapTest.add(q1);
        questionMapTest.add(q2);
        Assertions.assertEquals(mathQuestionService.getAll(),questionMapTest);
    }
    @Test
    public void addParametr(){
        mathQuestionService.add(1,2);
        questionMapTest.add(q1);
        Assertions.assertEquals(mathQuestionService.getAll(),questionMapTest);
    }
    @Test
    public void remove(){
        mathQuestionService.add(1,2);
        mathQuestionService.remove(new Question(1,2));
        Assertions.assertEquals(mathQuestionService.getAll(),questionMapTest);
    }
    @Test
    public void getAll(){
        mathQuestionService.add(q1);
        mathQuestionService.add(q2);
        mathQuestionService.add(q3);
        questionMapTest.add(q1);
        questionMapTest.add(q2);
        questionMapTest.add(q3);
        Assertions.assertEquals(mathQuestionService.getAll(),questionMapTest);
    }
    @Test
    public void getRandomQuestion(){
        questionMapTest.add(q1);
        Assertions.assertEquals(mathQuestionService.getRandomQuestion(),q1);
    }
}
