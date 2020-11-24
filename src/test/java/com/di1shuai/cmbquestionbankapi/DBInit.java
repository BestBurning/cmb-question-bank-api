package com.di1shuai.cmbquestionbankapi;

import com.di1shuai.questionbank.CmbQuestionBankApiApplication;
import com.di1shuai.questionbank.entity.Question;
import com.di1shuai.questionbank.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: Shea
 * @date: 2020/11/23
 * @description:
 */
@SpringBootTest(classes = CmbQuestionBankApiApplication.class)
public class DBInit {

    @Autowired
    QuestionRepository questionRepository;

    @Test
    public void init() throws IOException {
        String path = DBInit.class.getResource("/questions.txt").getPath();
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
            long count = questionRepository.count();
            Assert.isTrue(count > 100,"无法初始化数据");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }


    @Test
    public void cleanDB() {
        questionRepository.deleteAll();
        long count = questionRepository.count();
        Assert.isTrue(count == 0,"无法清除数据");

    }


}
