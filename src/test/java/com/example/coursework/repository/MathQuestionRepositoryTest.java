package com.example.coursework.repository;

import com.example.coursework.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MathQuestionRepositoryTest {
    MathQuestionRepository mathQuestionRepository = new MathQuestionRepository();
    private Set<Question> test = new HashSet<>();
    Question q1 = new Question(1, 2);
    Question q2 = new Question(3, 4);
    Question q3 = new Question(5, 6);

    @Test
    public void add() {
        mathQuestionRepository.add(q1);
        test.add(q1);
        Assertions.assertArrayEquals(mathQuestionRepository.getAll().toArray(), test.toArray());
        Assertions.assertEquals(mathQuestionRepository.add(q1), q1);
    }

    @Test
    public void addParam() {
        mathQuestionRepository.add(new Question(1, 2));
        test.add(q1);
        Assertions.assertArrayEquals(mathQuestionRepository.getAll().toArray(), test.toArray());
        Assertions.assertEquals(mathQuestionRepository.add(q1), q1);
    }

    @Test
    public void remove() {
        mathQuestionRepository.add(q1);
        mathQuestionRepository.remove(q1);
        Assertions.assertArrayEquals(mathQuestionRepository.getAll().toArray(), test.toArray());
        Assertions.assertEquals(mathQuestionRepository.remove(q1), q1);
    }

    @Test
    public void getAll() {
        mathQuestionRepository.add(q1);
        mathQuestionRepository.add(q2);
        mathQuestionRepository.add(q3);
        test.add(q1);
        test.add(q2);
        test.add(q3);
        Assertions.assertArrayEquals(mathQuestionRepository.getAll().toArray(), test.toArray());
    }
}
