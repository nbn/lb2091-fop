package dk.lundogbendsen.foundation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class FoundationApplication {


	public static void main(String[] args) {
		SpringApplication.run(FoundationApplication.class, args);
	}

	//@Bean
	public CommandLineRunner getStarter() {
		return args -> {
			System.out.println("Hello world");
		};
	}

	@Bean
	public String text() {
		return "hello text";
	}

}

