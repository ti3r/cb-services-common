package org.caringbridge.common.services.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.caringbridge.common.services.config.CorrelationFilterConfig;
import org.springframework.context.annotation.Import;
/**
 *
 * @author Alexandro Blanco <ablanco@caringbridge.com>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(CorrelationFilterConfig.class)
public @interface EnableCorrelationFilter {
    
}
