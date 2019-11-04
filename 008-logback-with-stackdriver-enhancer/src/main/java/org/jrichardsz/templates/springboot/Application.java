package org.jrichardsz.templates.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Application {

	private final Logger logger = LoggerFactory.getLogger(Application.class);

	@RequestMapping("/some/endpoint")
	@ResponseBody
	String home() {
		logger.info("starting endpoint controller");
		logger.info("endpoint controller has completed");
		return "Hello World!!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
