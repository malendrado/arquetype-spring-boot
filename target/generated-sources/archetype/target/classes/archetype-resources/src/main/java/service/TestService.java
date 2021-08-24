#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.config.RestTemplateConfig;
import ${package}.interfaces.ITestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Clase service de ejemplo, retorna succes: ok
 */
@Service
public class TestService implements ITestService {

    @Value("${symbol_dollar}{endpoint.test}")
    private String urlTest;
    
    @Autowired
    private RestTemplateConfig restTemplateConfig;

    @Override
    public Object getTest(){
        Object object = restTemplateConfig.getRestTemplate().getForObject(urlTest, Object.class);
        return object;
    }
}
