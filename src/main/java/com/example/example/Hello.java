package com.example.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Hello {
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String get() {
        return "hello, spring";
    }

    @RequestMapping(path = "/hello", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map post() {
        Map<String,Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "ok");
        return response;
    }
}
