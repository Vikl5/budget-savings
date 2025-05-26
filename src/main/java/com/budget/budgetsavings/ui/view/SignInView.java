package com.budget.budgetsavings.ui.view;

import com.budget.budgetsavings.auth.SupabaseAuthService;
import com.budget.budgetsavings.auth.dto.AuthResponse;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("signin")
public class SignInView extends VerticalLayout implements AfterNavigationObserver {

    private final SupabaseAuthService authService;

    public SignInView(SupabaseAuthService authService) {
        this.authService = authService;
        createLoginForm();
    }

    private void createLoginForm() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        LoginForm loginForm = new LoginForm();
        loginForm.setForgotPasswordButtonVisible(false);
        add(loginForm);

        loginForm.addLoginListener(e -> {
            try {
                String password = e.getPassword();
                String username = e.getUsername();
                AuthResponse response = authService.signIn(username, password);
                VaadinSession.getCurrent().setAttribute("user", response.user());
                UI.getCurrent().navigate("dashboard");

            } catch (Exception ex) {
                loginForm.setError(true);
                Notification.show("Login failed!");
            }

        });
        add(new H2("Sign in"), loginForm);
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        if (VaadinSession.getCurrent().getAttribute("user") != null) {
            UI.getCurrent().navigate("dashboard");
        }
    }
}