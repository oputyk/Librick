package com.oputyk.librick;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kamil on 03/02/2018.
 */

@RestController()
@RequestMapping("test/")
public class TestController {
    @GetMapping("hello")
    public TestDto hello() {
        return new TestDto("message nr 1", "message nr 2");
    }
}
