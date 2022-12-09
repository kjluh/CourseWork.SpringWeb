package com.example.coursework.controller;

import com.example.coursework.model.Question;
import com.example.coursework.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
//@RequestMapping("/exam")
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("java/listQuestion")
    public Collection<Question> getAll(@RequestParam("s") int size) {
        return examinerService.getQuestions(size);
    }




}
