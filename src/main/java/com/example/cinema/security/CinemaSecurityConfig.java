package com.example.cinema.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

import javax.sql.DataSource;

@Configuration
public class CinemaSecurityConfig{
    public String driverClass = "org.postgresql.Driver";
    public String url = "jdbc:postgresql://localhost:5432/postgres";
    public String username ="postgres";
    public String password = "zaq1@WSX";

    //to działą na pewno nie ruszać
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT email, password, active FROM users WHERE email=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT email, role FROM users WHERE email=?");
        return jdbcUserDetailsManager;

    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //http builder configurations for authorize requests and form login
        http.authorizeHttpRequests(config -> config
                .anyRequest().permitAll())
                .formLogin(form->form
                        .loginPage("/users/login")
                        .permitAll())
                .logout(logout->logout.permitAll()
                )
                .exceptionHandling(config->config
                        .accessDeniedPage("/accessDenied"));

        return http.build();

    }

}
