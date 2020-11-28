package com.di1shuai.questionbank.config;


import com.di1shuai.questionbank.enums.ErrorCode;
import com.di1shuai.questionbank.exception.BaseException;
import com.di1shuai.questionbank.vo.APIResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author: Shea
 * @date: 2020-04-22
 * @description:
 */
@EnableWebMvc
@Configuration
public class ExceptionConfig {

    @RestControllerAdvice("com.di1shuai.questionbank.controller")
    static class UnifiedExceptionHandler{


        @ExceptionHandler({BaseException.class})
        public APIResponse<Void> handleException(BaseException be){
            return APIResponse.error(be.getErrorCode());
        }

        @ExceptionHandler({Exception.class})
        public APIResponse<Void> handleAllException(Exception e){
            e.printStackTrace();
            return APIResponse.error(ErrorCode.RUNTIME_ERROR);
        }

    }

}
