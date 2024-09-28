package com.__found.found.logs;

import com.__found.found.logs.model.Log;
import com.__found.found.logs.service.RabbitMQPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FoundLogsApplication {

	public static void main(String[] args) {
		System.out.println("Log Application");

		ApplicationContext context = SpringApplication.run(FoundLogsApplication.class, args);

		// Get the RabbitMQPublisher bean from the application context
		RabbitMQPublisher rabbitMQPublisher = context.getBean(RabbitMQPublisher.class);

		Log log = new Log("abc","def","ghi","jkl");
		// Send a message to RabbitMQ
		rabbitMQPublisher.sendMessage(log.toString());
//		SpringApplication.run(FoundLogsApplication.class, args);
	}

}
