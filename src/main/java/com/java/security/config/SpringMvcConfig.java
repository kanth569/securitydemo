package com.java.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.java.security.mapper.SecurityMapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@ComponentScan(basePackages={"com.java.security.controller"})
@EnableWebMvc
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
	
    @SuppressWarnings("unused")
	@Bean
    public MapperFacade restServiceModelDomainMapperFacade() {

        MapperFactory restServiceModelDomainFactory = new DefaultMapperFactory.Builder().build();
        ConverterFactory converterFactory = restServiceModelDomainFactory.getConverterFactory();

        new SecurityMapper(restServiceModelDomainFactory);
        return restServiceModelDomainFactory.getMapperFacade();
    }
    
}
