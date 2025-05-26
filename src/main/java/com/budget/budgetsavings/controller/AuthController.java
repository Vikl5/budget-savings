package com.budget.budgetsavings.controller;

import com.budget.budgetsavings.auth.SupabaseAuthService;
import com.budget.budgetsavings.auth.dto.AuthResponse;
import com.budget.budgetsavings.auth.dto.SignInRequest;
import com.budget.budgetsavings.auth.dto.SignUpRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Allow CORS for frontend if we want to use React/JS at a later stage
public class AuthController {

    private final SupabaseAuthService supabaseAuthService;
    private final Logger logger = LogManager.getLogger(AuthController.class);

    public AuthController(SupabaseAuthService supabaseAuthService) {
        this.supabaseAuthService = supabaseAuthService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest request) {
        AuthResponse response = supabaseAuthService.signUp(request.email(), request.password());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestBody SignInRequest request) {
        AuthResponse response = supabaseAuthService.signIn(request.email(), request.password());
        return ResponseEntity.ok(response);
    }
}
