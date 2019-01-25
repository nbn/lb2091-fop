package dk.lundogbendsen.foundation.aspects;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class Service2 {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Service2.class);

    public Long calculateMortgage() {
      log.info("Calculating mortgage in service 2");
      return 50000000L;
    }

    public void somethingElse() {
        log.info("Doing something else in service 2");
    }
}
