package dk.lundogbendsen.foundation.config;

import dk.lundogbendsen.foundation.standard.DiceCup;
import dk.lundogbendsen.foundation.standard.Die;
import dk.lundogbendsen.foundation.standard.MultiDie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyDiceCupConfig {

    @Autowired @Qualifier("terning1")
    private Die terning;

    @Bean
    public DiceCup diceCup() {

        return new DiceCup(Arrays.asList(terning, new MultiDie()));
    }
}
