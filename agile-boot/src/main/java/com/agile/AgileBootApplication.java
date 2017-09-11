package com.agile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories("com.agile.repository")
@ComponentScan({"com.agile"})
public class AgileBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgileBootApplication.class, args);
	}
}
