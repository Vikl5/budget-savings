package com.budget.budgetsavings.auth;

import com.budget.budgetsavings.auth.dto.AuthResponse;
import com.budget.budgetsavings.auth.dto.SignInRequest;
import com.budget.budgetsavings.auth.dto.SignUpRequest;
import com.budget.budgetsavings.auth.util.SupabaseProperties;
import com.budget.budgetsavings.controller.AuthController;
import com.budget.budgetsavings.exceptions.BudgetException;
import com.vaadin.flow.server.VaadinSession;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class SupabaseAuthServiceImpl implements SupabaseAuthService {

    private final RestTemplate restTemplate;
    private final SupabaseProperties supabaseProperties;
    private final Logger logger = LogManager.getLogger(SupabaseAuthServiceImpl.class);


    public SupabaseAuthServiceImpl(SupabaseProperties supabaseProperties) {
        this.supabaseProperties = supabaseProperties;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AuthResponse signUp(String email, String password) {
        String url = supabaseProperties.getUrl() + "/auth/v1/signup";
        HttpHeaders headers = createHeaders();
        SignUpRequest request = new SignUpRequest(email, password);
        HttpEntity<SignUpRequest> entity = new HttpEntity<>(request, headers);

        try {
            AuthResponse response = restTemplate.postForObject(url, entity, AuthResponse.class);

            logger.info("Supabase signup response: {}", response);
            return response;

        } catch (Exception e) {
            logger.error("Error creating a new account for this user '{}' ", request.email());

            /*
            Ideally we throw our own exception here, but I have not implemented it yet
             */
            throw new NotImplementedException();
            //throw new BudgetException();
        }
    }


    @Override
    public AuthResponse signIn(String email, String password) {
        String url = supabaseProperties.getUrl() + "/auth/v1/token?grant_type=password";
        HttpHeaders headers = createHeaders();
        SignInRequest request = new SignInRequest(email, password);
        HttpEntity<SignInRequest> entity = new HttpEntity<>(request, headers);

        try {
            AuthResponse response = restTemplate.postForObject(url, entity, AuthResponse.class);
            ResponseEntity<String> rawResponse = restTemplate.postForEntity(url, entity, String.class);
            System.out.println("Raw Supabase signIn response: " + rawResponse.getBody());
            assert response != null;
            VaadinSession.getCurrent().setAttribute("user", response.user());

            return response;
        } catch (Exception e) {
            logger.error("Error signing in the following user: {}", request.email());

            /*
            Ideally we throw our own exception here, but I have not implemented it yet
             */
            throw new NotImplementedException();
            //throw new BudgetException();
        }
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", supabaseProperties.getAnonKey());
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
