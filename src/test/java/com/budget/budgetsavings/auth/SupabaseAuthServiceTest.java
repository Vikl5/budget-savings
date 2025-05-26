package com.budget.budgetsavings.auth;

import com.budget.budgetsavings.auth.dto.AuthResponse;
import com.budget.budgetsavings.auth.dto.SignInRequest;
import com.budget.budgetsavings.auth.dto.SignUpRequest;
import com.budget.budgetsavings.auth.util.SupabaseProperties;
import com.budget.budgetsavings.spring.SharedIntegrationTestsSpringContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Ideally in a production setting, we would mock the server we are hitting by for example
 * Adding spring context classes with Beans for each service we have.
 */
@ContextConfiguration(classes = SharedIntegrationTestsSpringContext.class)
public class SupabaseAuthServiceTest {

    private final String email = "kantinedama2@gmail.com";
    private final String password = "AndebyErBest123";
    private final SignInRequest signInRequest = new SignInRequest(email, password);
    private final SignUpRequest signUpRequest = new SignUpRequest(email, password);

    //@Autowired
    private SupabaseProperties supabaseProperties;

    //@Autowired
    private SupabaseAuthService supabaseAuthService;

    @BeforeEach
    public void setUp() {

        supabaseProperties = new SupabaseProperties();
        supabaseProperties.setUrl("");
        supabaseProperties.setAnonKey("");

        supabaseAuthService = new SupabaseAuthServiceImpl(supabaseProperties);

        assertNotNull(supabaseProperties.getUrl());

    }

    @Test
    public void signUp_Is_Successful() {
        AuthResponse signUp = supabaseAuthService.signUp(signUpRequest.email(), signUpRequest.password());
        assertEquals(email, signUp.user().email());
//        String accessToken = signUp.accessToken();
//        assertNotNull(accessToken);
    }

    @Test
    public void signIn() {
        AuthResponse signIn = supabaseAuthService.signIn(signInRequest.email(), signInRequest.password());
        assertEquals(email, signIn.user().email());
    }
}