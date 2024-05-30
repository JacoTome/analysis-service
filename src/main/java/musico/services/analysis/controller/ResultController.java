package musico.services.analysis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;


@Slf4j
@Controller
public class ResultController {

    @MessageMapping("/test")
    @SendTo("/topic/result")
    public String result(String message, Authentication auth) {
        try{
            log.info("User: {}", auth.getName());
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
        }
        log.info("Received message: {}", message);
        return "Hello, " + message + "!";
    }

}
