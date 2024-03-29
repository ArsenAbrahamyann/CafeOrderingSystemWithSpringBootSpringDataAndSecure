package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.security;

import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.aspects.LoggingAspect;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AopConfig {


    public LoggingAspect loggingAspect() {
        return new LoggingAspect(); // Create and configure your LoggingAspect here
    }
}
