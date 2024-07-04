package com.scaler.project.productservice.userservice.configs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {

    //@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(request ->{
            try{
                request.anyRequest().permitAll()
                        .and().cors().disable()
                        .csrf().disable();
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }).build();
    }

}
