package com.__found.found.logs.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

@Service
public class LogstashTcpReceiver {

    @Autowired
    private RabbitMQPublisher rabbitMQPublisher; // Inject RabbitMQ publisher

    private static final int PORT = 5044; // Same port as in Logstash config

    @PostConstruct
    public void startTcpServer() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("Listening for Logstash messages on port: " + PORT);

                while (true) {
                    Socket socket = serverSocket.accept(); // Accept incoming connections
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Received message from Logstash: " + message);
                        // Publish the received message to RabbitMQ
                        rabbitMQPublisher.sendMessage(message);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}