package com.java.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@SpringBootApplication(scanBasePackages={"com.java.security.*"})
@EnableJms
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.java.security.dao.repository" })
@EntityScan(basePackages = "com.java.security.domain")
@EnableAutoConfiguration
public class SecuritydemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SecuritydemoApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SecuritydemoApplication.class);
	}
}
