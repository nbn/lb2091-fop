package dk.lundogbendsen.foundation.aspects;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class Service1 {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Service1.class);

    public String calculateInterest() {
        log.info("Calculating interest in service 1");
        return "500";
    }

}
