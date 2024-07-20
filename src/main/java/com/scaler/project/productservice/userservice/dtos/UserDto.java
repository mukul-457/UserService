package com.scaler.project.productservice.userservice.dtos;

import com.scaler.project.productservice.userservice.models.Role;
import com.scaler.project.productservice.userservice.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String email;
    private String name;
    private List<Role> roles;

    public  UserDto(String email, String name){
        this.email = email;
        this.name = name;
    }
    public static UserDto fromEntity(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setRoles(user.getRoles());
        return userDto;
    }
}
