package info.office.security;

import java.time.Clock;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Crypto {

	  public static void main(String[] args) {
		  Clock clock=Clock.systemDefaultZone();
		int i = 0;
		while (i < 10) {
			String password = "user";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
			System.out.println(clock.instant());
			i++;
		}
		
		

	  }
	}
