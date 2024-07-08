package com.scaler.project.productservice.userservice.security.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.scaler.project.productservice.userservice.models.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@JsonDeserialize
@NoArgsConstructor
public class CustomGrantedAuthority  implements GrantedAuthority{
    private String authority;

    public CustomGrantedAuthority(Role role){
        this.authority = role.getName();
    }
    @Override
    public String getAuthority() {
        return authority;
    }
}
