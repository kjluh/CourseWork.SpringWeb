package com.example.coursework.controller;

import com.example.coursework.model.Question;
import com.example.coursework.service.MathQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class MathQuestionController {
    private final MathQuestionService mathQuestionService;

    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/math/add/{question}/{answer}")
    public Question addParam(@PathVariable("question") int question,
                             @PathVariable("answer") int answer) {
        excep(question);
        excep(answer);
        return mathQuestionService.add(question, answer);
    }

    @GetMapping("/math/add")
    public Question add(@RequestParam("question") int question,
                        @RequestParam("answer") int answer) {
        excep(question);
        excep(answer);
        Question example = new Question(question, answer);
        return mathQuestionService.add(example);
    }

    @GetMapping("/math/remove")
    public Question remove(@RequestParam("question") int question,
                           @RequestParam("answer") int answer) {
        excep(question);
        excep(answer);
        Question example = new Question(question, answer);
        return mathQuestionService.remove(example);
    }

    @GetMapping("/math")
    public Collection<Question> getAll() {
        return mathQuestionService.getAll();
    }

    private void excep(Object s) {
        if (s == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ввели не все данные");
        }
    }
}
