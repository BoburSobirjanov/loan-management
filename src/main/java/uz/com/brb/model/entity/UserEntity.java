package uz.com.brb.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class UserEntity{

    private Integer id;
    private String fullName;
    private String password;
    private String username;
    private UserRole role;
    private final LocalDateTime createAt = LocalDateTime.now();
}
