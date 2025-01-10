package uz.com.brb.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Clients {

    private Integer id;
    private Integer userId;
    private String name;
    private String email;
    private String number;
    private final LocalDateTime createdAt = LocalDateTime.now();
}
