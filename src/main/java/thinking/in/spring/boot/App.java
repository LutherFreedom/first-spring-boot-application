package thinking.in.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import thinking.in.spring.boot.config.WebServer;

/**
 * Hello world!
 */

// SpringBootApplication = Configuration+EnableAutoConfiguration+ComponentScan
//@SpringBootApplication

//@Configuration
@EnableAutoConfiguration
//@ComponentScan
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}
