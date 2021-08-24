package it.pkg.config;

import it.pkg.interfaces.IExampleService;
import it.pkg.interfaces.ITestService;
import it.pkg.service.ExampleService;
import it.pkg.service.TestService;

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
