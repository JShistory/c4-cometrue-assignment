package org.c4marathon.assignment.openMarket.dto;

import lombok.Builder;
import lombok.Data;
import org.c4marathon.assignment.openMarket.domain.User;
import org.c4marathon.assignment.openMarket.domain.UserRole;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private String accountId;
    private String password;
    private String name;
    private String nickName;
    private String phoneNumber;
    @Builder
    public UserDTO(String accountId, String password, String name, String nickName, String phoneNumber) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
    }

    public User toEntity(){
        return User.builder()
                .accountId(this.accountId)
                .password(this.password)
                .name(this.name)
                .nickName(this.nickName)
                .phoneNumber(this.phoneNumber)
                .role(UserRole.USER)
                .modify(LocalDateTime.now())
                .create(LocalDateTime.now())
                .build();
    }
}
