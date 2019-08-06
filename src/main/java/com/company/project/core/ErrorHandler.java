package com.company.project.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 * @author Leish
 */
@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Throwable.class)
    public Result defaultErrorHandler(Throwable e) {
        log.error("服务器异常:", e);
        return Result.genFailResult(e.getCause().getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result defaultErrorHandler(MethodArgumentNotValidException e) {
        log.error("参数校验异常:", e);
        return Result.genFailResult(e.getBindingResult().getFieldError().getDefaultMessage());
    }
}

