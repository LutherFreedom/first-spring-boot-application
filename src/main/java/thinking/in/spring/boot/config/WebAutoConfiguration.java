package thinking.in.spring.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/6/1 11:49
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
@Configuration
@Import(WebServer.class)
public class WebAutoConfiguration {
}
