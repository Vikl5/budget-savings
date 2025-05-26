package com.budget.budgetsavings.auth;

import com.budget.budgetsavings.auth.dto.AuthResponse;

public interface SupabaseAuthService {


    AuthResponse signUp(String email, String password);


    AuthResponse signIn(String email, String password);
}
