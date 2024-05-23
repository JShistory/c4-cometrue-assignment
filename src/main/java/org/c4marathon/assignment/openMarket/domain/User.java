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
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime modified;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE) // 회원이 삭제되면, 회원 물품도 삭제
    private List<Item> items;

    @Builder
    public User(Long id, String accountId, String password, String name, String nickName, String phoneNumber,String email, Long money,
                UserRole role,
                LocalDateTime created, LocalDateTime modified, List<Item> items) {
        this.id = id;
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.created = created;
        this.modified = modified;
        this.money = money;
        this.items = items;
    }

    public User() {

    }

    public void buyItem(Long price){
        long money = this.money - price;
        if(money < 0){
            throw new IllegalStateException("금액이 부족합니다.");
        }
        this.money -= price;
    }
}
