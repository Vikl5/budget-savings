package com.budget.budgetsavings.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthResponse(
        @JsonProperty("access_token")
        String accessToken,

        @JsonProperty("refresh_token")
        String refreshToken,

        @JsonProperty("expires_in")
        Long expiresIn,

        @JsonProperty("token_type")
        String tokenType,

        User user
) {

    @Override
    public String toString() {
        return "AuthResponse{" +
                "accessToken='" + accessToken.length() + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", user=" + user +
                '}';
    }
}
