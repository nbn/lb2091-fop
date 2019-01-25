package dk.lundogbendsen.foundation.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggableAspect {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LoggableAspect.class);

    @Pointcut("@annotation(dk.lundogbendsen.foundation.logging.Loggable)")
    public void whenLoggable() {}


    @Before("whenLoggable()")
    public void logBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String[] arguments = (String[]) args[0];
        log.info("Logging before execution {}", arguments);
    }
}
