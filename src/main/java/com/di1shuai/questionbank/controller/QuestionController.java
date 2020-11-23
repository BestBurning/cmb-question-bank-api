package com.di1shuai.questionbank.controller;

import com.di1shuai.questionbank.entity.Question;
import com.di1shuai.questionbank.repository.QuestionRepository;
import com.di1shuai.questionbank.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Shea
 * @date: 2020/11/22
 * @description:
 */
@RequestMapping("/question")
@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;



    @GetMapping("/search/{keywords}")
    public List<Question> search(@PathVariable(name = "keywords") String keywords) {
        return questionService.search(keywords);
    }


    




}
