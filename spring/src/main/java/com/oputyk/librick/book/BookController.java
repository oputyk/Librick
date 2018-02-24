package com.oputyk.librick.book;

import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.common.converter.reflection.operator.method.MethodOperatorImpl;
import com.oputyk.librick.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

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
