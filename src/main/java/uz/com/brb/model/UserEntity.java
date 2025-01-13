package uz.com.brb.model;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserEntity {
    private int id;
    private String username;
    private String password;
    private String role;
    private LocalDateTime createdAt = LocalDateTime.now();

    public UserEntity(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

