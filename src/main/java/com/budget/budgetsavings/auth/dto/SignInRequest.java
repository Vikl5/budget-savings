package com.budget.budgetsavings.auth.dto;

public record SignInRequest(
        String email,
        String password
) {
    @Override
    public String toString() {
        return "SignInRequest{" +
                "email='" + email.length() + '\'' +
                '}';
    }
}
