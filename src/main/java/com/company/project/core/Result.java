package com.company.project.core;


import lombok.Data;

/**
 * 统一API响应结果封装
 */
@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result(ResultCode.SUCCESS.code,DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result(ResultCode.SUCCESS.code,DEFAULT_SUCCESS_MESSAGE,data);
    }

    public static Result genFailResult(String message) {
        return new Result(ResultCode.FAIL.code,message);
    }

    /**
     * 响应码枚举，参考HTTP状态码的语义
     */
    public enum ResultCode {
        SUCCESS(200),//成功
        FAIL(400),//失败
        UNAUTHORIZED(401),//未认证（签名错误）
        NOT_FOUND(404),//接口不存在
        INTERNAL_SERVER_ERROR(500);//服务器内部错误

        private final int code;

        ResultCode(int code) {
            this.code = code;
        }

        public int code() {
            return code;
        }
    }
}


