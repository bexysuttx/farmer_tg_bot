package bexysuttx.farmerTGBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FarmerTgBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmerTgBotApplication.class, args);
	}

}
