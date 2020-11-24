package com.di1shuai.questionbank.repository;

import com.di1shuai.questionbank.entity.Question;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Shea
 * @date: 2020/11/23
 * @description:
 */
@Repository
public interface QuestionRepository extends ElasticsearchRepository<Question,String> {

    List<Question> findByQuestionLike(String keywords);

}
