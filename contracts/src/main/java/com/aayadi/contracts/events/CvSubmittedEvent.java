package com.aayadi.contracts.events;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record CvSubmittedEvent(
        UUID eventId,
        String eventType,
        Instant occurredAt,
        Data data
) {
    public record Data(
            UUID candidateId,
            String fullName,
            String title,
            List<String> skills,
            int yearsOfExperience
    ) {}
}