package dk.lundogbendsen.foundation.config;

import dk.lundogbendsen.foundation.standard.BasicDie;
import dk.lundogbendsen.foundation.standard.Die;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@ImportResource("classpath:/hello.xml")
@ComponentScan("dk.lundogbendsen.foundation.dynamic")
public class MyBeanConfig {

   @Bean
   public Die terning1() {
       return new BasicDie();
   }

    @Bean
    public String mytext() {
        return new String("Strengværdi");
    }

    @Bean
    public String mytext2() {
        return new String("Strengværdi2");
    }

}
