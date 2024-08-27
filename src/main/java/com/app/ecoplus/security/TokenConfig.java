package com.app.ecoplus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class TokenConfig {

    @Autowired
    private CustomUserDetailsService UserDetailsService;

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/user/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/user/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/form-api").permitAll()
                        .requestMatchers(HttpMethod.POST, "/submitForm ").permitAll()
                        .requestMatchers(HttpMethod.GET, "/","/faq",
                                "/loginconta/**",
                                "/password","/form",
                                "/criarconta",
                                "/criarcontadois",
                                "/chat",
                                "/sobrenos")
                        .permitAll()
                        .requestMatchers("/css/faq.css"
                                ,"/css/form.css"
                                ,"/css/media.css"
                                ,"/css/responsive.css"
                                ,"/css/sobrenos.css"
                                ,"/css/style.css"
                                ,"/css/styleeco.css"
                                ,"/js/btn-menu-mob.js"
                                ,"/js/form.js"
                                ,"/js/menu.js"
                                ,"/js/script.js"
                                ,"/img/**")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
