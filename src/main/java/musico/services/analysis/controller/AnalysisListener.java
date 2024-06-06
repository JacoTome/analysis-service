package musico.services.analysis.controller;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class AnalysisListener {

    private final SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "audio_analysis", groupId = "analysis-service")
    /*
    TODO:
        - Replace String with AnalysisMessage
    * */
    public void listen(String message) {
        log.info(message);
        String[] fields = message.split(",");
        String session = fields[0];
        String sessionValue = session.split(":")[1];
        sessionValue =  sessionValue.replace("\"", "");
        log.info("Sending message to {}", sessionValue);
        messagingTemplate.convertAndSendToUser(sessionValue, "/queue/result", message);
    }
}
