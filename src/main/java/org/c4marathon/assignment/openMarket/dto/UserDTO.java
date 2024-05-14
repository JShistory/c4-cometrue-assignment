package org.c4marathon.assignment.openMarket.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.c4marathon.assignment.openMarket.domain.User;
import org.c4marathon.assignment.openMarket.domain.UserRole;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    @NotNull(message = "아이디는 필수 입력입니다.")
    @Size(min = 5, max = 15, message = "이름은 5 ~ 15자 이여야 합니다.")
    private String accountId;
    @NotNull(message = "패스워드는 필수 입력입니다.")
    private String password;
    @NotNull(message = "이름은 필수 입력입니다.")
    @Size(min = 2, max = 10)
    private String name;
    private String nickName;
    @NotNull(message = "핸드폰 번호는 필수 입력입니다.")
    private String phoneNumber;
    @NotNull(message = "이메일은 필수 입력입니다.")
    @Email
    private String email;
    @Builder
    public UserDTO(String accountId, String password, String name, String nickName, String phoneNumber, String email) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User toEntity(){
        return User.builder()
                .accountId(this.accountId)
                .password(this.password)
                .name(this.name)
                .nickName(this.nickName)
                .phoneNumber(this.phoneNumber)
                .role(UserRole.USER)
                .email(this.email)
                .money(0L)
                .modify(LocalDateTime.now())
                .create(LocalDateTime.now())
                .build();
    }
}
