package com.tuempresa.inventario.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuration class for security-related beans.
 * This class primarily provides the PasswordEncoder bean, which is essential 
 * for securely hashing client passwords before database storage.
 * * NOTE: This requires the 'spring-boot-starter-security' dependency in pom.xml.
 */
@Configuration
public class SecurityConfig {

    /**
     * Defines the BCryptPasswordEncoder bean.
     * BCrypt is the industry-standard hashing algorithm for passwords.
     * The ClientService will use this bean to encode passwords.
     * @return an instance of PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
