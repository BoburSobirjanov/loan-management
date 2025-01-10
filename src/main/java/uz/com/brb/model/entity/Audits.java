package uz.com.brb.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Audits {

    private Integer id;
    private Integer managedId;
    private String action;
    private final LocalDateTime createdAt = LocalDateTime.now();
}
