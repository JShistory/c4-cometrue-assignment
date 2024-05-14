package org.c4marathon.assignment.openMarket.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Entity
@Table(name = "USER_TABLE")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountId;
    private String password;
    private String name;
    private String nickName;
    private String phoneNumber;
    private Long money;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @CreatedDate
    private LocalDateTime create;
    @LastModifiedDate
    private LocalDateTime modify;

    @Builder
    public User(Long id, String accountId, String password, String name, String nickName, String phoneNumber,String email, Long money,
                UserRole role,
                LocalDateTime create, LocalDateTime modify) {
        this.id = id;
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.create = create;
        this.modify = modify;
        this.money = money;
    }

    public User() {

    }
}
