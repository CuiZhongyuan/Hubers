package com.interfacetest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;
@MapperScan("com.interfacetest.mapper")
@EnableScheduling
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class Application {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args){
        Application.context = SpringApplication.run(Application.class,args);
    }
    @PreDestroy
    public void close(){
        Application.context.close();
    }
}
