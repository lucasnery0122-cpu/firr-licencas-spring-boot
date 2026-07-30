package com.example.firr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita para permitir POST/PUT/DELETE locais
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // Libera o banco para testes
                        .anyRequest().authenticated() // Exige autenticação para os endpoints da API
                )
                .headers(headers -> headers.frameOptions(frame -> frame.disable())) // Necessário para o H2 Console
                .httpBasic(Customizer.withDefaults()); // Ativa a autenticação Básica (User/Senha)

        return http.build();
    }
}