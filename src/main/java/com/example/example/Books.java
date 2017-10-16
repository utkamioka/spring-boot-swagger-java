package com.example.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> get() {
        return Arrays.asList("1", "2", "3");
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Book get(@PathVariable("id") String id) {
        return new Book(id, "abc");
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
