package com.example.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String get() {
        return "hello, spring";
    }
}
