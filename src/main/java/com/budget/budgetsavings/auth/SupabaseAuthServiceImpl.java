package com.budget.budgetsavings.auth;

import com.budget.budgetsavings.auth.dto.AuthResponse;
import com.budget.budgetsavings.auth.dto.SignInRequest;
import com.budget.budgetsavings.auth.dto.SignUpRequest;
import com.budget.budgetsavings.auth.util.SupabaseProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SupabaseAuthServiceImpl implements SupabaseAuthService {

    private final RestTemplate restTemplate;
    private final SupabaseProperties supabaseProperties;

    public SupabaseAuthServiceImpl(SupabaseProperties supabaseProperties) {
        this.supabaseProperties = supabaseProperties;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AuthResponse signUp(String email, String password) {
        String url = supabaseProperties.getUrl() + "/auth/v1/signup";

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", supabaseProperties.getAnonKey());
        headers.setContentType(MediaType.APPLICATION_JSON);

        SignUpRequest request = new SignUpRequest(email, password);
        HttpEntity<SignUpRequest> entity = new HttpEntity<>(request, headers);

        return restTemplate.postForObject(url, entity, AuthResponse.class);
    }

    @Override
    public AuthResponse signIn(String email, String password) {
        String url = supabaseProperties.getUrl() + "/auth/v1/token?grant_type=password";

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", supabaseProperties.getAnonKey());
        headers.setContentType(MediaType.APPLICATION_JSON);

        SignInRequest request = new SignInRequest(email, password);
        HttpEntity<SignInRequest> entity = new HttpEntity<>(request, headers);

        return restTemplate.postForObject(url, entity, AuthResponse.class);
    }
}
