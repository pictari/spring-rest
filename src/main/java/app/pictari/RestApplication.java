package app.pictari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RestApplication {

    @RequestMapping("/")
    public String home() {
        return "[insert something funny here]";
    }

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}