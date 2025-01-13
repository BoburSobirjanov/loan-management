package uz.com.brb.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Audits {

    private Integer id;
    private Integer managerId;
    private String action;
    private final LocalDateTime createdAt = LocalDateTime.now();
}
