package dk.lundogbendsen.foundation.dynamic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component(value="myHelloService")
@Slf4j
public class Hello {

    @Autowired
    @Qualifier("mytext2")
    private String name;

    public Hello() {
//        this.name = name;
//        log.info("navnet som sættes i Hello er " + name);
    }

    @PostConstruct
    public void init() {
        log.info("Im init 2");
    }

    @Override
    public String toString() {
        return "Hej " + name;
    }
}
