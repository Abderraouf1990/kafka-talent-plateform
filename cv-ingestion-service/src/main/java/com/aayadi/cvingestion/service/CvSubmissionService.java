package com.aayadi.cvingestion.service;


import com.aayadi.contracts.apis.CvSubmitRequest;
import com.aayadi.contracts.apis.CvSubmitResponse;
import com.aayadi.contracts.mappers.CvEventMapper;
import com.aayadi.cvingestion.exception.PublishFailedException;
import com.aayadi.cvingestion.kafka.CvEventProducer;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class CvSubmissionService {

    private final CvEventProducer producer;
    private final CvEventMapper mapper;

    public CvSubmissionService(CvEventProducer producer, CvEventMapper mapper) {
        this.producer = producer;
        this.mapper = mapper;
    }

    public CvSubmitResponse submit(CvSubmitRequest req) {
        UUID candidateId = UUID.randomUUID();
        UUID eventId = UUID.randomUUID();
        Instant occurredAt = Instant.now();

        var event = mapper.toEvent(req, candidateId, eventId, occurredAt);
        try {
            producer.publish(event);
        } catch (Exception e) {
            throw new PublishFailedException("Failed to publish CV event", e);
        }

        return new CvSubmitResponse(candidateId, eventId, occurredAt, "ACCEPTED");
    }
}