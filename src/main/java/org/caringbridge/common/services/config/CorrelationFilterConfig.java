package org.caringbridge.common.services.config;

import org.caringbridge.common.services.filter.CorrelationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Configuration class that creates a new instance of the
 * CorrelationFilter class and registers it in the context as a 
 * bean in order to be used in the application. 
 * This class can be used with @Import or by including @EnableCorrelationIdFilter
 * configuration annotation (preferred way).
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 */
@Configuration
public class CorrelationFilterConfig {
    
    
    @Bean(name = "correlationFilterBean")
    public CorrelationFilter createCorrelationFilterBean(){
        return new CorrelationFilter();
    }
}
