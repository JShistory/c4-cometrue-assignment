package org.c4marathon.assignment.openMarket.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    @Builder
    public User(Long id, String accountId, String password, String name, String nickName, String phoneNumber,String email, Long money,
                UserRole role,
                LocalDateTime create, LocalDateTime modify, List<Item> items) {
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
        this.items = items;
    }

    public User() {

    }
}
