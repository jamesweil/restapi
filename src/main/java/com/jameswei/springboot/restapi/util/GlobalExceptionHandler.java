package com.jameswei.springboot.restapi.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String, String> errorHandler(Exception ex) {
        Map<String, String> data = new HashMap<>();
        data.put("errorCode", "500");
        data.put("errorMsg", ex.toString());
        return data;
    }
}
