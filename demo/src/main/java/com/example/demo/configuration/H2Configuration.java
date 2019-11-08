package com.example.demo.configuration;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import young.mcap.research.tenant.scope.TenantScope;

@Configuration
@ConfigurationProperties(prefix = "h2")
@Profile("h2")
public class H2Configuration {

    private String userName;

    private String password;

    private String url;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Bean
    public static CustomScopeConfigurer provideCustomScopeConfigurer() {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("tenant", new TenantScope());
        return customScopeConfigurer;
    }
}
