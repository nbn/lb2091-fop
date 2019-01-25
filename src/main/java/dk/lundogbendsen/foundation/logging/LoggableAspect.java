package dk.lundogbendsen.foundation.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggableAspect {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LoggableAspect.class);

    @Before("@annotation(dk.lundogbendsen.foundation.logging.Loggable)")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Logging before execution {}" + joinPoint);
    }
}
