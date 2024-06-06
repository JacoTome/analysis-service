package musico.services.analysis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.web.exchanges.HttpExchange;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Slf4j
@Controller
public class ResultController {

    @MessageMapping("/test")
    @SendToUser("/queue/result")
    public String result(@Payload String message, Principal principal) {
        log.info("Received message: {} from {}", message, principal.getName());
        return message;
    }

}
