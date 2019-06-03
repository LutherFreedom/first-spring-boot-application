package thinking.in.spring.boot.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/6/1 10:41
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
//@SpringBootApplication
@RestController
//@EnableAutoConfiguration
@Configuration
public class WebServer {
    @RequestMapping("/")
    public String index() {
        return "Welcome, My Buddy";
    }


    @Bean
    public RouterFunction<ServerResponse> helloWorld(){
        return RouterFunctions.route(RequestPredicates.GET("/hello-world"),
                serverRequest -> ServerResponse.ok().body(Mono.just("Hello, World"), String.class));
    }

//    @Bean
//    public ApplicationRunner runner(WebServerApplicationContext context){
//        return args -> System.out.println("当前WebServer实现类是：" + context.getWebServer().getClass().getName());
//    }

    @Bean
    public ApplicationRunner runner(BeanFactory factory){
        return args -> {
            System.out.println("当前HelloWorld Bean 实现类为：" + factory.getBean("helloWorld").getClass().getName());
            System.out.println("当前WebServer Bean 实现类为：" + factory.getBean(WebServer.class).getClass().getName());
        };
    }

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event){
        String handlers = System.getProperty("java.protocol.handler.pkgs", "");
        System.out.println(handlers);
        System.out.println("Event 当前WebServer的PORT是："+ event.getWebServer().getPort());
        System.out.println("Event 当前WebServer实现类是：" + event.getApplicationContext().getWebServer().getClass().getName());
    }
}
