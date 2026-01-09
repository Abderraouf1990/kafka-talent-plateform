package com.aayadi.cvingestion.kafka;


import com.aayadi.contracts.events.CvSubmittedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CvEventProducer {

    private final KafkaTemplate<String, CvSubmittedEvent> kafkaTemplate;
    private final String topic;

    public CvEventProducer(KafkaTemplate<String, CvSubmittedEvent> kafkaTemplate,
                           @Value("${app.topics.cvSubmitted}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
        kafkaTemplate.setObservationEnabled(true);
    }

    public void publish(CvSubmittedEvent event) {
        kafkaTemplate.send(topic, event.data().candidateId().toString(), event);
    }
}
