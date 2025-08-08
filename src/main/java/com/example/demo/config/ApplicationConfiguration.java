package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.example.demo",
        useDefaultFilters = true,
        includeFilters =  @ComponentScan.Filter(type = FilterType.ANNOTATION)
)
public class ApplicationConfiguration {

}
