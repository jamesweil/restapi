package com.jameswei.springboot.restapi.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @RequestMapping("/")
    public Map<String, String> index() {
        Map<String, String> data = new HashMap<>();
        data.put("data", "Welcome to REST API demo.");
        return data;
    }
}
