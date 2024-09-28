package com.__found.found.logs.service;
import com.__found.found.logs.config.RabbitMQConfig;
import com.__found.found.logs.model.Log;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQPublisher {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private String exchange = RabbitMQConfig.EXCHANGE_NAME;
    private String routingKey = RabbitMQConfig.ROUTING_KEY;

    public void sendMessage(String message) {
        amqpTemplate.convertAndSend(exchange, routingKey, message);
        System.out.println("Sent message: " + message);
    }
}