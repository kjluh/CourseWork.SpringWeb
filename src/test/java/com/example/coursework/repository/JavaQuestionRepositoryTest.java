package com.example.coursework.repository;

import com.example.coursework.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class JavaQuestionRepositoryTest {
    JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();
    private Set<Question> test = new HashSet<>();
    Question q1 = new Question("test1","test11");
    Question q2 = new Question("test2","test12");
    Question q3 = new Question("test3","test13");
    @Test
    public void add(){
        javaQuestionRepository.add(q1);
        test.add(q1);
        Assertions.assertArrayEquals(javaQuestionRepository.getAll().toArray(),test.toArray());
        Assertions.assertEquals(javaQuestionRepository.add(q1),q1);
    }
    @Test
    public void addParam(){
        javaQuestionRepository.add(new Question("test1","test11"));
        test.add(q1);
        Assertions.assertArrayEquals(javaQuestionRepository.getAll().toArray(),test.toArray());
        Assertions.assertEquals(javaQuestionRepository.add(q1),q1);
    }
    @Test
    public void remove(){
        javaQuestionRepository.add(q1);
        javaQuestionRepository.remove(q1);
        Assertions.assertArrayEquals(javaQuestionRepository.getAll().toArray(),test.toArray());
        Assertions.assertEquals(javaQuestionRepository.remove(q1),q1);
    }
    @Test
    public void getAll(){
        javaQuestionRepository.add(q1);
        javaQuestionRepository.add(q2);
        javaQuestionRepository.add(q3);
        test.add(q1);
        test.add(q2);
        test.add(q3);
        Assertions.assertArrayEquals(javaQuestionRepository.getAll().toArray(),test.toArray());
    }
}
