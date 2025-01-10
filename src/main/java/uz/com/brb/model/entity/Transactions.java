package uz.com.brb.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transactions {

    private Integer id;
    private Integer accountId;
    private String transactionType;
    private Long amount;
    private final LocalDateTime createdAt = LocalDateTime.now();
}
