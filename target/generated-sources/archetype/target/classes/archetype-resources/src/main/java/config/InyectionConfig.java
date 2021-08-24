#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import ${package}.interfaces.IExampleService;
import ${package}.interfaces.ITestService;
import ${package}.service.ExampleService;
import ${package}.service.TestService;

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
