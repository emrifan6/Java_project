package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("web")
public class SpringBootFirstWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFirstWebApplication.class, args);
    }
}
