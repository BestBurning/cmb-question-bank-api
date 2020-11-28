package com.di1shuai.questionbank.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum APICode{
    SUCCESS(0),
    ERROR(1);

    private int code;

    @JsonValue
    public int getCode(){
        return this.code;
    }

    @Override
    public String toString() {
        return String.valueOf(this.code);
    }


}