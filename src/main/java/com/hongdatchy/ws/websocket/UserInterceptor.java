package com.hongdatchy.ws.websocket;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

import java.util.List;

public class UserInterceptor implements ChannelInterceptor {



    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        System.out.println("message:       " + message);
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);

        // -> cai send cung can co token, can xu ly them cai y

        if (StompCommand.CONNECT.equals(accessor.getCommand())) {

            List<String> tokenList = accessor.getNativeHeader("token");
            List<String> userList = accessor.getNativeHeader("username");
            if(tokenList == null || userList == null){
                return null;
            }else{
                String token = tokenList.get(0);
                String username = userList.get(0);
                if(token.equals(username)){ // check validate token
                    return message;
                }else {
                    return null;// reject connect
                }
            }
        }
        if (StompCommand.SEND.equals(accessor.getCommand())) {
            System.out.println("here authenticate send");
        }
        return message;
    }
}
