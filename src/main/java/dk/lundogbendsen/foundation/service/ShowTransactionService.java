package dk.lundogbendsen.foundation.service;


import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShowTransactionService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ShowTransactionService.class);

    public void doSomething() {
        log.info("Doing something");
        throw new RuntimeException("Ups");
    }
}
