package dk.lundogbendsen.foundation;

import dk.lundogbendsen.foundation.standard.BasicDie;
import dk.lundogbendsen.foundation.standard.DiceCup;
import dk.lundogbendsen.foundation.standard.Die;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ImportResource("classpath:hello.xml")
public class FoundationApplication {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(FoundationApplication.class, args);
	}


	@Bean
	public CommandLineRunner manual() {
		return args -> {
			List<Die> dice = Arrays.asList(
					new BasicDie(), new BasicDie()
			);
		   DiceCup d = new DiceCup(dice);

		   System.out.println("Manually defined, gives me : " + d.sum());
		};
	}
	@Bean
	public CommandLineRunner fromContext() {
		return args -> {
			DiceCup bean = applicationContext.getBean(DiceCup.class);
			System.out.println("Found in context, gives me : " + bean.sum());
		};
	}

}

