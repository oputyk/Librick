package com.oputyk.librick.author;

import com.oputyk.librick.author.dto.FullAuthorDto;
import com.oputyk.librick.author.service.AuthorService;
import com.oputyk.librick.book.dto.FullBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kamil on 04/02/2018.
 */

@RestController
@RequestMapping("author/secure")
public class AuthorSecureController {

    private final AuthorService authorService;

    @Autowired
    public AuthorSecureController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PreAuthorize("hasRole('ROLE_LIBRARIAN')")
    @PostMapping("author")
    public FullAuthorDto updateOrSaveAuthor(@RequestBody FullAuthorDto fullAuthorDto) {
        return authorService.updateOrSaveAuthor(fullAuthorDto);
    }

    @PreAuthorize("hasRole('ROLE_LIBRARIAN')")
    @DeleteMapping("author/{id}")
    public boolean delete(@PathVariable Long id) {
        return authorService.deleteAuthor(id);
    }

}
