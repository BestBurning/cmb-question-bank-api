package com.di1shuai.questionbank.exception;

import com.di1shuai.questionbank.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Shea
 * @date: 2020-04-22
 * @description:
 */
@Data
@AllArgsConstructor
public class BaseException extends RuntimeException  {


    protected ErrorCode errorCode;

}
