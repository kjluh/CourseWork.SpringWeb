package com.example.coursework.controller;

import com.example.coursework.model.Question;
import com.example.coursework.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("get/{amount}")
    public Collection<Question> getAll(@PathVariable("amount") int size) {
        return examinerService.getQuestions(size);
    }




}
