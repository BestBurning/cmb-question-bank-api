package com.di1shuai.questionbank.controller;

import com.di1shuai.questionbank.enums.ErrorCode;
import com.di1shuai.questionbank.exception.BaseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Shea
 * @date: 2020/11/28
 * @description:
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(path = "/exception")
    public Object exceptionTest() {
        throw new BaseException(ErrorCode.NOT_FIND);
    }

    @GetMapping(path = "/empty")
    public void emptyTest() {
        System.out.println("empty");
    }
}
