package kz.medet.trello.config;

import kz.medet.trello.service.UserService;
import kz.medet.trello.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService()).passwordEncoder(passwordEncoder());

        http.exceptionHandling(
                exception -> exception.accessDeniedPage("/forbidden")
        );

        http.authorizeRequests(
                authorize -> authorize
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/home","/getCategoriesPage").authenticated()
                        .requestMatchers("/sign-in", "/entering").anonymous()
                        .requestMatchers("/sign-out").authenticated()
                        .requestMatchers("/profile").authenticated()
                        .requestMatchers("/css/**", "/js/**").permitAll()
                        .anyRequest().permitAll()
        ).formLogin(
                login -> login
                        .loginProcessingUrl("/entering")
                        .defaultSuccessUrl("/profile")
                        .loginPage("/")
                        .failureUrl("/")
                        .usernameParameter("user_email")
                        .passwordParameter("user_password")
        ).logout(
                logout -> logout
                        .logoutSuccessUrl("/")
                        .logoutUrl("/sign-out")
        ).csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
