package app.pictari;

import app.pictari.aws.dynamodb.DynamoRequestHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RestApplication {

    DynamoRequestHandler dynamoHandler = new DynamoRequestHandler();
    @RequestMapping("/")
    public String home() {
        return "[insert something funny here]";
    }

    @RequestMapping("/rooms")
    public String roomListEndpoint() { return dynamoHandler.getAllRooms("sample-data");}

    public static void main(String[] args) {
        SpringApplication spring = new SpringApplication(RestApplication.class);
        spring.setWebApplicationType(WebApplicationType.SERVLET);
        spring.run(args);
    }
}