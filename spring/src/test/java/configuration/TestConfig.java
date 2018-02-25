package configuration;

import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.dto.BookDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * Created by kamil on 24/02/2018.
 */

@Configuration
@Profile("test")
public class TestConfig {

}
