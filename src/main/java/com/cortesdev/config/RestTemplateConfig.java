package com.cortesdev.config;

import com.cortesdev.interceptor.LoggingInterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Configuration
public class RestTemplateConfig {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate = null;
        
        if (log.isDebugEnabled()) {
            ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory( new SimpleClientHttpRequestFactory() );
            restTemplate = new RestTemplate(factory);
        } else {
            restTemplate = new RestTemplate();
        }
  
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new LoggingInterceptor());
        restTemplate.setInterceptors(interceptors);

        return restTemplate;
    }
    
}