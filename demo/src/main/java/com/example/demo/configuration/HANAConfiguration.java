package com.example.demo.configuration;

import com.sap.db.jdbcext.HanaDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "hana")
@Profile("hana")
public class HANAConfiguration {

    private String userName;

    private String password;

    private String url;

    private String driverClassName;

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

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Bean
    DataSource getDataSource() {
        HanaDataSource dataSource = new HanaDataSource();
        dataSource.setUrl(this.url);
        dataSource.setUser(this.userName);
        dataSource.setPassword(this.password);
        dataSource.setPort(30015);
        dataSource.setSchema("BIZX_BIZXTEST");
        return dataSource;
    }
}
