package com.di1shuai.questionbank.vo;


import com.di1shuai.questionbank.enums.APICode;
import com.di1shuai.questionbank.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: Shea
 * @date: 2020-04-21
 * @description:
 *
 * {
 *     "code": 1,
 *     "data":{},
 *     "error":{
 *         "code":"1001",
 *         "message":""
 *     }
 * }
 *
 */
@Data
@Accessors(chain = true)
public class APIResponse<T> {

    private APICode code;

    private T data;

    private Error error;



    public static <T> APIResponse<T> error(ErrorCode errorCode){
        APIResponse<T> response = new APIResponse<>();
        response.code = APICode.ERROR;
        response.error = new Error(errorCode.getCode(),errorCode.getMessage());
        return response;
    }

    public static <T> APIResponse<T> error(ErrorCode errorCode,String detail){
        APIResponse<T> response = new APIResponse<>();
        response.code = APICode.ERROR;
        response.error = new Error(errorCode.getCode(),detail);
        return response;
    }

    public static <T> APIResponse<T> success(T data){
        APIResponse<T> response = new APIResponse<>();
        response.code = APICode.SUCCESS;
        response.data = data;
        return response;
    }



}

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
class Error{

    private String code;

    private String message;

}