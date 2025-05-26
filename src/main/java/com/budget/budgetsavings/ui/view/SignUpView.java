package com.budget.budgetsavings.ui.view;

import com.budget.budgetsavings.auth.SupabaseAuthService;
import com.budget.budgetsavings.auth.dto.AuthResponse;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route("signup")
public class SignUpView extends VerticalLayout {

    private final SupabaseAuthService authService;

    public SignUpView(SupabaseAuthService authService) {
        this.authService = authService;
        createSignUpForm();
    }

    public void createSignUpForm() {
        TextField email = new TextField("Email");
        PasswordField password = new PasswordField("Password");
        Button signUpButton = new Button("Sign Up");

        signUpButton.addClickListener(e -> {
            try {
                AuthResponse success = authService.signUp(email.getValue(), password.getValue());
                Notification.show("Sign up successful! Please sign in");
            } catch (Exception ex) {
                Notification.show("Sign up failed!", 3000, Notification.Position.MIDDLE);
            }
        });

        add(email, password, signUpButton);
    }
}
