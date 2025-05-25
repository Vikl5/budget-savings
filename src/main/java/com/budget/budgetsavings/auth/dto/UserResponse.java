package com.budget.budgetsavings.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserResponse(
        String id,

        String email,

        String role,

        @JsonProperty("created_at")
        String createdAt,

        @JsonProperty("updated_at")
        String updatedAt
) {
}
