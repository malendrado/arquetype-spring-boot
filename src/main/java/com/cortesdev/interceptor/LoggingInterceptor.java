package com.cortesdev.interceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoggingInterceptor implements ClientHttpRequestInterceptor {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public ClientHttpResponse intercept( HttpRequest req, byte[] reqBody, ClientHttpRequestExecution exec) throws IOException {
                
        log.debug("Request body");
        ClientHttpResponse response = exec.execute(req, reqBody);
  
        if (log.isDebugEnabled()) {
          log.debug("Response body");
        }
  
        return response;
    }
}
