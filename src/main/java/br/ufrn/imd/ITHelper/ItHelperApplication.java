package br.ufrn.imd.ITHelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "br.ufrn.imd.ITHelper")
public class ItHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItHelperApplication.class, args);
	}

}
