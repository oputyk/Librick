package com.oputyk.librick.book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kamil on 04/02/2018.
 */

@RestController
@RequestMapping("book")
public class BookController {
    @RequestMapping("hi")
    public String hi() {
        return "hi";
    }
}
