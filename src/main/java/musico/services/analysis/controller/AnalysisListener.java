package musico.services.analysis.controller;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

//@Component
@AllArgsConstructor
public class AnalysisListener {

    private final SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "audio_analysis", groupId = "analysis-service")
    public void listen(String message) {
        messagingTemplate.convertAndSend("/topic/result", message);
    }
}
