package com.di1shuai.questionbank.repository;

import com.di1shuai.questionbank.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Shea
 * @date: 2020/11/22
 * @description:
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
