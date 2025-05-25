package com.budget.budgetsavings.auth.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "supabase")
@Data
public class SupabaseProperties {
    private String url;
    private String anonKey;
    private String serviceRoleKey;
    private String jwtSecret;


    @Override
    public String toString() {
        return "SupabaseProperties{" +
                "url='" + url + '\'' +
                ", anonKey='" + anonKey + '\'' +
                ", serviceRoleKey='" + serviceRoleKey + '\'' +
                ", jwtSecret='" + jwtSecret.length() + '\'' +
                '}';
    }
}
