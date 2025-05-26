package com.budget.budgetsavings.ui.config;

import com.budget.budgetsavings.ui.view.LandingPageView;
import com.budget.budgetsavings.ui.view.SignInView;
import com.budget.budgetsavings.ui.view.SignUpView;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VaadinConfig {

    /**
     * Redirects every query to the landing view page if they are not signed in. Allows only
     * SignIn and SignUp views
     */
    @Bean
    public VaadinServiceInitListener accessControlInitListener() {
        return event -> event.getSource().addUIInitListener(uiInitEvent -> {
            uiInitEvent.getUI().addBeforeEnterListener(routeEvent -> {
                Class<?> target = routeEvent.getNavigationTarget();
                VaadinSession session = VaadinSession.getCurrent();


                if (target.equals(LandingPageView.class)
                        || target.equals(SignInView.class)
                        || target.equals(SignUpView.class)) {
                    return;
                }

                if (session.getAttribute("user") == null) {
                    routeEvent.forwardTo(LandingPageView.class);
                }
            });
        });
    }
}
