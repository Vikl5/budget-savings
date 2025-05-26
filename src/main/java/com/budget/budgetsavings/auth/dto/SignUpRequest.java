package com.budget.budgetsavings.auth.dto;

public record SignUpRequest(
        String email,
        String password
) {
    @Override
    public String toString() {
        return "SignInRequest{" +
                "email='" + email + '\'' +
                '}';
    }
    }
