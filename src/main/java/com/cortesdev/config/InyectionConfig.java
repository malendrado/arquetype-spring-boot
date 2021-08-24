package com.cortesdev.config;

import com.cortesdev.interfaces.IExampleService;
import com.cortesdev.interfaces.ITestService;
import com.cortesdev.service.ExampleService;
import com.cortesdev.service.TestService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InyectionConfig {

    @Bean
    public ITestService iTestService(){
        return new TestService();
    } 
    
    @Bean
    public IExampleService iExampleService(){
        return new ExampleService();
    }
}
