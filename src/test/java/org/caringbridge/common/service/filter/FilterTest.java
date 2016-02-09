package org.caringbridge.common.service.filter;

import static org.mockito.Mockito.*;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.caringbridge.common.services.filter.CorrelationFilter;
import org.junit.Test;

public class FilterTest {
	private static final String CORRELATION_ID_HEADER = "X-Request-Id";
	private static final String MISSING_REQUEST_ID_VALUE = "none";

	@Test
	public void nullRequestIdShouldReturnNull() {
		HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
		HttpServletResponse mockedResponse = mock(HttpServletResponse.class);
		FilterChain mockedFilterChain = mock(FilterChain.class);
		
		when(mockedRequest.getHeader(CORRELATION_ID_HEADER)).thenReturn(MISSING_REQUEST_ID_VALUE);
		
		CorrelationFilter filter = new CorrelationFilter();
		try {
			filter.doFilter(mockedRequest, mockedResponse, mockedFilterChain);
			verify(mockedRequest).getHeader(CORRELATION_ID_HEADER);
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

}
