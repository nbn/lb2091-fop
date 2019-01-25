package dk.lundogbendsen.foundation.tracing;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogDurationAspect {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger("TRACING");

    @Pointcut("@annotation(dk.lundogbendsen.foundation.tracing.LogDuration)")
    public void annotatedWithLogDuration() {}



    @Around("annotatedWithLogDuration()")
    public void logDuration(ProceedingJoinPoint joinPoint) throws Throwable {

        String name = joinPoint.toShortString();

        long before = System.currentTimeMillis();

        try {
            joinPoint.proceed();
        } finally {
            long after = System.currentTimeMillis();

            long time = (after - before);

            log.info("It took {} ms to execute {}", time, name);
        }
    }
}
