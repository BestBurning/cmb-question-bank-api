package com.di1shuai.questionbank.service;

import com.di1shuai.questionbank.entity.Question;
import com.di1shuai.questionbank.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: Shea
 * @date: 2020/11/22
 * @description:
 */
@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> search(String keywords) {
        String[] strings = keywords.trim().split(" ");
        Arrays.stream(strings).distinct().filter(s -> !s.equals(" "));
        List<Question> all = questionRepository.findAll();

        return all;
    }


    public Boolean loadData() throws IOException {

        String path = QuestionService.class.getResource("/questions.txt").getPath();
        System.out.println(path);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            AtomicReference<Question> lastQ = new AtomicReference<>();
            List<Question> list = new ArrayList<>();
            bufferedReader.lines().forEach(s -> {
                if (s.startsWith("Q")) {
                    Question question = new Question();
                    String replace = s.replace("：", ":");
                    int index = replace.indexOf(":");
                    lastQ.set(question.setQuestion(replace.substring(index + 1).trim()));
//                    System.out.println(lastQ.get());

                } else if (s.startsWith("A")) {
                    String replace = s.replace("：", ":");
                    int index = replace.indexOf(":");
                    lastQ.get().setAnswer(replace.substring(index + 1).trim());
                    list.add(lastQ.get());
                }


            });
            list.forEach(q -> {
                System.out.println("Q: " + q.getQuestion());
                System.out.println("A: " + q.getAnswer());
            });

            questionRepository.saveAll(list);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        QuestionService questionService = new QuestionService();
        questionService.loadData();


    }

}
