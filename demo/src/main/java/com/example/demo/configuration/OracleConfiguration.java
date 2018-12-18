package com.example.demo.configuration;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "oracle")
@Profile("dev")
public class OracleConfiguration {

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
    DataSource getDataSource() {
        return DataSourceBuilder.create().type(OracleDataSource.class)
                .username(userName)
                .url(url)
                .password(password)
                .build();
    }

}
