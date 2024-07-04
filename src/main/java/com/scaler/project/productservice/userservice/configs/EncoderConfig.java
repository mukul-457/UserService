package com.scaler.project.productservice.userservice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class EncoderConfig {

//    @Primary
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        String idForEncode = "bcrypt";
//        Map<String, PasswordEncoder> encoderMap = new HashMap<>();
//        encoderMap.put(idForEncode, new BCryptPasswordEncoder());
//
//        return new DelegatingPasswordEncoder(idForEncode, encoderMap);
//    }
}
