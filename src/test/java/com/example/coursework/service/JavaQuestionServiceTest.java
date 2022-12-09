package com.example.coursework.service;

import com.example.coursework.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class JavaQuestionServiceTest {
    private Set<Question> questionMapTest = new HashSet<>();
    JavaQuestionService javaQuestionService = new JavaQuestionService();
    Question q1 = new Question("test1","test11");
    Question q2 = new Question("test2","test12");
    Question q3 = new Question("test3","test13");
//    Question q4 = new Question("test4","test14");
//    Question q5 = new Question("test5","test15");
//    Question q6 = new Question("test6","test16");

    @Test
    public void addObject(){
        javaQuestionService.add(q1);
        javaQuestionService.add(q2);
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
        javaQuestionService.add(q1);
        Assertions.assertEquals(javaQuestionService.getRandomQuestion(),q1);
    }
}
