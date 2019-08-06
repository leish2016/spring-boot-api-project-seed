package com.company.project.core;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一API响应结果封装
 * @author leish
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    public Result(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    /**
     * 消息状态码
     */
    private String respCode;
    /**
     * 消息
     */
    private String respMsg;
    /**
     * 需要返回的内容
     */
    private T data;


    /**
     * 处理成功
     */
    public final static String SUCCESS = "200";

    /**
     * 处理失败
     */
    public final static String FAIL = "400";


    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result(SUCCESS,DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result(SUCCESS,DEFAULT_SUCCESS_MESSAGE,data);
    }

    public static Result genFailResult(String message) {
        return new Result(FAIL,message);
    }

}


