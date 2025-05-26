package com.budget.budgetsavings.spring;

import com.budget.budgetsavings.auth.SupabaseAuthService;
import com.budget.budgetsavings.auth.SupabaseAuthServiceImpl;
import com.budget.budgetsavings.auth.util.SupabaseProperties;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SharedIntegrationTestsSpringContext implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Bean
    public SupabaseAuthService supabaseAuthService() {
        SupabaseProperties supabaseProperties = supabaseProperties();
        return new SupabaseAuthServiceImpl(supabaseProperties);
    }

    @Bean
    public SupabaseProperties supabaseProperties() {
        SupabaseProperties supabaseProperties = new SupabaseProperties();

        supabaseProperties.setUrl(System.getProperty("supabase.url"));
        supabaseProperties.setAnonKey(System.getProperty("supabase.anon-key"));
        return supabaseProperties;
    }

}
