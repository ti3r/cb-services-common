package org.caringbridge.common.services.annotations;

import org.caringbridge.common.services.filter.config.CorrelationFilterConfig;
import static org.junit.Assert.assertNotNull;
import org.springframework.context.annotation.Import;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Unit test in order to test the inclusion of the right
 * configuration when @EnableCorrelationFilter annotation
 * is added.
 * 
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 */
public class EnableCorrelationFilterTest {
    
    /**
     * test method to check the annotation
     */
    @Test
    public void testEnableCorrelationFilter(){
        
        TestConfig tc = new TestConfig();
        EnableCorrelationFilter ann = tc.getClass().getAnnotation(EnableCorrelationFilter.class);
        Import annotation = EnableCorrelationFilter.class.getAnnotation(Import.class);
        
        assertNotNull("A class annotated with @EnableCorrelationFilter should retain it during runtime",ann);
        assertNotNull("A class annotated with @EnableCorrelationFilter should have @Import annotation",annotation);
        assertTrue("The value of @Import in @EnableCorrelationFilter should be CorrelationFilterConfig",
                (annotation.value().length >0 && annotation.value()[0].equals(CorrelationFilterConfig.class) ));
    }
    
    
    @EnableCorrelationFilter
    class TestConfig{
        
    }
    
}
