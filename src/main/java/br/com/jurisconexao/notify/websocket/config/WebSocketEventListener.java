package br.com.jurisconexao.notify.websocket.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import br.com.jurisconexao.notify.models.Notification;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {

    private  SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        Notification notification = (Notification) headerAccessor.getSessionAttributes().get("username");
        if (notification != null) {
         
           
            messagingTemplate.convertAndSend("/topic/public", notification);
        }
    }

}
