package com.di1shuai.questionbank.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Shea
 * @date: 2020-04-21
 * @description:
 */

@AllArgsConstructor
@Getter
public enum ErrorCode {

    NOT_SIGNIN("4001","未登录"),
    SIGNIN_NOT_FIND("4002","未找到该用户"),
    NOT_FIND("4004","资源未找到"),
    SIGNIN_CREDENTIAL_ERROR("4005","验证错误"),

    SIGNUP_NOT_VERIFIED("4101","注册信息未验证"),
    SIGNUP_IDENTITY_REPEAT("4102","注册信息重复"),
    SIGNUP_NOT_SUPPORT("4103","注册方式不支持"),
    SIGNUP_NOT_FIND("4104","注册信息未找到"),
    SIGNUP_DEAD_TIME("4105","验证码过期"),

    METHOD_ARGUMENT_NOT_VALID("4201","参数校验错误"),


    RUNTIME_ERROR("5000","服务器错误，请稍后尝试"),

    ;

    private String code;

    private String message;

    @JsonValue
    public Map getJson(){
        Map erroy = new HashMap();
        erroy.put("code",code);
        erroy.put("message",message);
        return erroy;
    }

}
