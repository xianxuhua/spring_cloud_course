package com.example.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static final Logger logger = LoggerFactory.getLogger(EurekaApplication.class);
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EurekaApplication.class);
        ConfigurableEnvironment environment = application.run(args).getEnvironment();
        logger.info("Eureka启动地址:{}", environment.getProperty("server.port"));
    }
}
