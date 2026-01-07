package com.aayadi.contracts.apis;

import java.time.Instant;
import java.util.UUID;

public record CvSubmitResponse(
        UUID candidateId,
        UUID eventId,
        Instant occurredAt,
        String status
) {}