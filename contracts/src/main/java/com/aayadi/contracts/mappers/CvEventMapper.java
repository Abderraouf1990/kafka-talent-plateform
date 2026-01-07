package com.aayadi.contracts.mappers;


import com.aayadi.contracts.apis.CvSubmitRequest;
import com.aayadi.contracts.events.CvSubmittedEvent;
import org.mapstruct.*;
import java.time.Instant;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CvEventMapper {

    @Mapping(target = "eventId", source = "eventId")
    @Mapping(target = "eventType", constant = "cv-submitted")
    @Mapping(target = "occurredAt", source = "occurredAt")
    @Mapping(target = "data", expression = "java(toData(candidateId, req))")
    CvSubmittedEvent toEvent(CvSubmitRequest req, UUID candidateId, UUID eventId, Instant occurredAt);

    default CvSubmittedEvent.Data toData(UUID candidateId, CvSubmitRequest req) {
        return new CvSubmittedEvent.Data(
                candidateId,
                req.fullName(),
                req.title(),
                req.skills(),
                req.yearsOfExperience()
        );
    }
}