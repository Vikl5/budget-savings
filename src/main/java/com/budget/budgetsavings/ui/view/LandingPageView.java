package com.budget.budgetsavings.ui.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("")
public class LandingPageView extends VerticalLayout implements AfterNavigationObserver {

    public LandingPageView() {
        add(new Text("Sign in to view the rest!"));

        Button signin = new Button("Login", e -> UI.getCurrent().navigate("signin"));
        Button signup = new Button("Sign Up", e -> UI.getCurrent().navigate("signup"));

        add(signin, signup);
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        if (VaadinSession.getCurrent().getAttribute("user") != null) {
            UI.getCurrent().navigate("dashboard");
        }
    }
}
