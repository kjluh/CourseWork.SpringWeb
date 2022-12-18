package com.example.coursework.service;

import com.example.coursework.model.Question;
import com.example.coursework.repository.JavaQuestionRepository;
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
public class JavaQuestionServiceTest {

    @Mock
    JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    JavaQuestionService javaQuestionService;
    private Set<Question> questionMapTest = new HashSet<>();
    Question q1 = new Question("test1","test11");
    Question q2 = new Question("test2","test12");
    Question q3 = new Question("test3","test13");
    @BeforeEach
    public void set(){
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(questionMapTest);
    }

    @Test
    public void addObject(){
        questionMapTest.add(q1);
        questionMapTest.add(q2);
        Assertions.assertEquals(javaQuestionService.getAll(),questionMapTest);
    }
    @Test
    public void addParametr(){
        javaQuestionService.add("test1","test11");
        questionMapTest.add(q1);
        Assertions.assertEquals(javaQuestionService.getAll(),questionMapTest);
    }
    @Test
    public void remove(){
        javaQuestionService.add("test1","test11");
        javaQuestionService.remove(new Question("test1","test11"));
        Assertions.assertEquals(javaQuestionService.getAll(),questionMapTest);
    }
    @Test
    public void getAll(){
        javaQuestionService.add(q1);
        javaQuestionService.add(q2);
        javaQuestionService.add(q3);
        questionMapTest.add(q1);
        questionMapTest.add(q2);
        questionMapTest.add(q3);
        Assertions.assertEquals(javaQuestionService.getAll(),questionMapTest);
    }
    @Test
    public void getRandomQuestion(){
        questionMapTest.add(q1);
        Assertions.assertEquals(javaQuestionService.getRandomQuestion(),q1);
    }
}
