package am.picsartacademy.springboot.cafeorderingsystem.security;

import am.picsartacademy.springboot.cafeorderingsystem.aspects.LoggingAspect;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AopConfig {


    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
