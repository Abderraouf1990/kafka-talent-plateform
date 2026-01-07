package com.aayadi.contracts.apis;

import java.util.List;
import java.util.UUID;

public record TalentProfileResponse(
        UUID candidateId,
        String fullName,
        String title,
        List<String> skills,
        int yearsOfExperience
) {}