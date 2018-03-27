package info.office;


import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class WebRegApplication {
	private Logger logger = Logger.getLogger(getClass().getName());
	public static void main(String[] args) {
		SpringApplication.run(WebRegApplication.class, args);
		
	}
		 
}
