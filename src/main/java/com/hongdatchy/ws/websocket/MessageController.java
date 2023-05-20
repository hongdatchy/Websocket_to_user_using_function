package com.hongdatchy.ws.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void sendMessage(@Header String from, @Header String to, @Payload String payload) {

        String message = "Dear " + to + " ,i am " + from + ". " + payload;

        simpMessagingTemplate.convertAndSend("/queue/messages/" + to, message);
    }
}
