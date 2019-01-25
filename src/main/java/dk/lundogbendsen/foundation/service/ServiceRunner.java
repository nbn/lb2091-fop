package dk.lundogbendsen.foundation.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class ServiceRunner implements CommandLineRunner
{
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ServiceRunner.class);

    @Autowired
    private ShowTransactionService showTransactionService;

    @Override
    public void run(String... args) {
      log.info("Starting a service transaction");
      try {
          showTransactionService.doSomething();
      } finally {
          log.info("Completed");
      }

    }
}
