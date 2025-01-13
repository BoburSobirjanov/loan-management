package uz.com.brb.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Accounts {

    private Integer id;
    private Integer clientId;
    private String accountType;
    private Long balance;
    private Integer interestRate;
    private final LocalDateTime createdAt = LocalDateTime.now();

}
