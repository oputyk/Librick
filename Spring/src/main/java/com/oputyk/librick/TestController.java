package com.oputyk.librick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kamil on 03/02/2018.
 */

@RestController()
@RequestMapping("test/")
public class TestController {
    @Autowired
    TestDtoRepository testDtoRepository;

    @GetMapping("hello")
    public TestDto hello() {
        TestDto testDto = TestDto.builder()
                .message("message nr 1")
                .message2("message nr 2")
                .build();
        testDtoRepository.save(testDto);

        return testDtoRepository.findOne(1L);
    }
}
