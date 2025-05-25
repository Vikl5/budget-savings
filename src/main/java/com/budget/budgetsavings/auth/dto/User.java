package com.budget.budgetsavings.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(
        String id,

        String email,

        String role,

        @JsonProperty("email_confirmed_at")
        String emailConfirmedAt,

        @JsonProperty("created_at")
        String createdAt,

        @JsonProperty("updated_at")
        String updatedAt
) {
}
