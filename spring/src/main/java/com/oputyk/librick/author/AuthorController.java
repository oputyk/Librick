package com.oputyk.librick.author;

import com.oputyk.librick.author.dto.AuthorDto;
import com.oputyk.librick.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kamil on 04/02/2018.
 */

@RestController
@RequestMapping("author")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("all")
    public List<AuthorDto> all() {
        return authorService.findAllAuthorDtos();
    }
}
