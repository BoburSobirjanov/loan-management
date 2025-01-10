package uz.com.brb.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Loans {

    private Integer id;
    private Integer clientId;
    private Long amount;
    private Integer interestRate;
    private String status;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private String dueDate;
}
