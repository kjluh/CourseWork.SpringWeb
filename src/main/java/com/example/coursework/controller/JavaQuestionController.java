package com.example.coursework.controller;

import com.example.coursework.model.Question;
import com.example.coursework.service.JavaQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/java/add/{quest}/{ans}")
    public Question addQuestion(
            @PathVariable("quest") String question,
            @PathVariable("ans") String answer) {
        excep(question);
        excep(answer);
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("java/add")
    public Question addQuestion1(
            @RequestParam("q") String question,
            @RequestParam("a") String answer) {
        Question x = new Question(question, answer);
        excep(x);
        return javaQuestionService.add(x);
    }

    @GetMapping("/java/remove/{quest}/{ans}")
    public Question remove(
            @PathVariable("quest") String question,
            @PathVariable("ans") String answer) {
        Question x = new Question(question, answer);
        excep(x);
        return javaQuestionService.remove(x);
    }

    @GetMapping("/java")
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

    private void excep(Object s) {
        if (s == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ввели не все данные");
        }
    }
}
