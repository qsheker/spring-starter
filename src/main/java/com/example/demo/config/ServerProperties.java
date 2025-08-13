package com.example.demo.config;


import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "server")
public record ServerProperties
    (String host,
     int port,
     boolean sslEnabled){
}
