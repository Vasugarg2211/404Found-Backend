//package com.__found.found.logs.service;
//
//import com.__found.found.logs.config.RabbitMQConfig;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RabbitMQConsumer {
//
//    // Listen to the queue for incoming messages
//    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
//    public void receiveMessage(String message) {
//        System.out.println("Received message from RabbitMQ: " + message);
//        // Process the message here
//    }
//}