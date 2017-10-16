package com.example.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/books")
public class Books {
    public static class Book {
        public String id;
        public String title;
        public Book() {}
        public Book(String id, String title) {
            this.id = id;
            this.title = title;
        }

        @Override
        public String toString() {
            return "Book[" + this.id + "/" + this.title + "]";
        }
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Book get() {
        return new Book("1", "abc");
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map post(@RequestBody Book book) {
        System.out.println("book = " + book);
        Map<String,Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "ok");
        return response;
    }
}
