package com.aayadi.contracts.apis;

import jakarta.validation.constraints.*;
import java.util.List;

public record CvSubmitRequest(
        @NotBlank String fullName,
        @NotBlank String title,
        @NotNull @Size(min = 1) List<@NotBlank String> skills,
        @Min(0) @Max(60) int yearsOfExperience
) {}
