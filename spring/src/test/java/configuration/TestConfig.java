package configuration;

import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.dto.BookDto;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * Created by kamil on 24/02/2018.
 */

@Configuration

public class TestConfig {
    private String newBookName = "Book name";
    private Date newBookRealeaseDate = new Date();
    private long newBookId = 1L;;
    private String newBookDescription = "Some description about the book.";
    private Long oldBookId = newBookId + 3L;

    @Scope("prototype")
    @Bean
    public BookEntity bookEntity1() {
        return BookEntity.builder()
                .id(newBookId)
                .name(newBookName)
                .releaseDate(newBookRealeaseDate)
                .description(newBookDescription)
                .build();
    }

    @Scope("prototype")
    @Bean
    public BookDto bookDto1() {
        return BookDto.builder()
                .id(newBookId)
                .name(newBookName)
                .releaseDate(newBookRealeaseDate)
                .description(newBookDescription)
                .build();
    }

    @Scope("prototype")
    @Bean
    public BookEntity bookEntity2() {
        return BookEntity.builder()
                .id(oldBookId)
                .build();
    }
}
