package dk.lundogbendsen.foundation.logging;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;

//@Component
public class LoggableRunner implements CommandLineRunner {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LoggableRunner.class);

    @Override
    @Loggable
    public void run(String... args) {
        log.info("Testing something");
    }
}
