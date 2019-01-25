package dk.lundogbendsen.foundation.aspects;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class AspectRunner implements CommandLineRunner {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(AspectRunner.class);
    @Autowired
    private Service1 service1;

    @Autowired
    private Service2 service2;

    @Override
    public void run(String... args) throws Exception {
        log.info("Running aspect examle");

        service1.calculateInterest();

        service2.calculateMortgage();

        service2.somethingElse();


    }
}
