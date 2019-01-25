package dk.lundogbendsen.foundation.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculateAspect {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CalculateAspect.class);

    // Good docs: https://docs.spring.io/spring/docs/4.3.15.RELEASE/spring-framework-reference/html/aop.html


    // Execution = Normal, full pointcut (Describe entire signature), e.g. execution(void set*(..))
    // Within = Limit it to a certain package or type, e.g. within(dk.lundogbendsen.foundation.aspects)
    // Args = Limit it to args of certain type, e.g. args(java.io.Serializable)
    // @target = Limit it to annotations on target object
    // @annotation = Limit it to annotation on methods

    // Ususal to specify pointcuts on a method
    @Pointcut("execution(* calculate*(..))")
    public void whenCalculating() {}

    // Then write the advice
    @AfterReturning(pointcut = "whenCalculating()", returning = "retval")
    public void  afterCalculation(Long retval) {
      log.info("Calculation method is returning {}", retval);
    }










    // Advice types
    // @Before, @After, @AfterReturning, @AfterThrowing, @Around

    //@Around("within(dk.lundogbendsen.foundation.aspects.Service2)")
    public void aroundService2(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Before calling {}", joinPoint.toLongString());
        joinPoint.proceed();
        log.info("After returning from {}", joinPoint.toLongString());
    }



    @Before("execution(public * calculateInterest(..))")
    public void somethingHappeningBeforeTheMEthodsThatINeedToFind(JoinPoint joinPoint) {
        log.info("Before {}", joinPoint.toLongString());
    }

}
