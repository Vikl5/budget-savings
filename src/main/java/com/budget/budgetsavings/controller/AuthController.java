package com.budget.budgetsavings.controller;

import com.budget.budgetsavings.auth.SupabaseAuthService;
import com.budget.budgetsavings.auth.dto.AuthResponse;
import com.budget.budgetsavings.auth.dto.SignInRequest;
import com.budget.budgetsavings.auth.dto.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final SupabaseAuthService supabaseAuthService;

    public AuthController(SupabaseAuthService supabaseAuthService) {
        this.supabaseAuthService = supabaseAuthService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest request) {
        try {
            AuthResponse response = supabaseAuthService.signUp(request.email(), request.password());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestBody SignInRequest request) {
        try {
            AuthResponse response = supabaseAuthService.signIn(request.email(), request.password());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
