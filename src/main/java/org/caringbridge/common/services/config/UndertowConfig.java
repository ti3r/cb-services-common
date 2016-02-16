package org.caringbridge.common.services.config;

import org.springframework.context.annotation.Configuration;

import io.undertow.UndertowOptions;
import io.undertow.Undertow.Builder;

import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@Configuration
public class UndertowConfig {
	/**
	 * Sets the record-request-start-time to true so that Undertow will track
	 * the request time and report it in the access logs if the '%D' is added to
	 * the logging pattern.
	 * 
	 * @return
	 */
	@Bean
	public UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
		final UndertowEmbeddedServletContainerFactory undertowEmbeddedServletContainerFactory = new UndertowEmbeddedServletContainerFactory();
		undertowEmbeddedServletContainerFactory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
			@Override
			public void customize(Builder builder) {
				builder.setServerOption(UndertowOptions.RECORD_REQUEST_START_TIME, true);
			}
		});
		return undertowEmbeddedServletContainerFactory;
	}
}
