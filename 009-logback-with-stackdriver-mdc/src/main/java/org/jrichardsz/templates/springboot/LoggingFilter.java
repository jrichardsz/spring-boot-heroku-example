package org.jrichardsz.templates.springboot;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//https://www.baeldung.com/mdc-in-log4j-2-logback
@Component
@Order(1)
public class LoggingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String uuid = UUID.randomUUID().toString();

		MDC.put("uuid", uuid);
		MDC.put("app", "api-rest");
		chain.doFilter(request, response);
	}

	// other methods
}
