package musico.services.analysis.controller;

import lombok.AllArgsConstructor;
import musico.services.analysis.models.AnalysisMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class AnalysisListener {

    private final SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "audio_analysis", groupId = "analysis-service",
            containerFactory = "kafkaListenerContainerFactory")
    /*
    TODO:
        - Replace String with AnalysisMessage
    * */
    public void listen(@Payload AnalysisMessage message) {
        log.info("Received message from: {}", message.getUser());
        messagingTemplate.convertAndSendToUser(message.getUser(), "/queue/result", message.getDanceability());
    }
}
