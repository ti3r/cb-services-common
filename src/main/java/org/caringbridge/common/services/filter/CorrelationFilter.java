package org.caringbridge.common.services.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.MDC;
/**
 * The CorrelationFilter will pull out the request ID (X-Request-Id) from the header and add it to the 
 * logging context (MDC) so that subsequent logs will include it. This allows log entries to be 
 * correlated to a single request.
 * 
 * @author Craig Smith
 *
 */
public class CorrelationFilter implements Filter {
	private static final String CORRELATION_ID_HEADER = "X-Request-Id";
	private static final String MISSING_REQUEST_ID_VALUE = "none";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
	        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	        String currentCorrId = httpServletRequest.getHeader(CORRELATION_ID_HEADER);
	        // Adding a correlation ID of 'none' because there are many log statements that are happening outside of a request
	        // and this will help identify which requests are missing a request ID
	        MDC.put(CORRELATION_ID_HEADER, currentCorrId.isEmpty() ? MISSING_REQUEST_ID_VALUE : currentCorrId);
	        chain.doFilter(request, response);
		} finally {
			// Removing the MDC variable will avoid any potential memory leak issues associate with ThreadLocal storage.
			MDC.remove(CORRELATION_ID_HEADER);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
