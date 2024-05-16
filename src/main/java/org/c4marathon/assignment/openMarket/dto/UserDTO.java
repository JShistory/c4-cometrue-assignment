package org.c4marathon.assignment.openMarket.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.c4marathon.assignment.openMarket.domain.Item;
import org.c4marathon.assignment.openMarket.domain.User;
import org.c4marathon.assignment.openMarket.domain.UserRole;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDTO {
    private Long id;
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
    private Long money;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @CreatedDate
    private LocalDateTime create;
    @LastModifiedDate
    private LocalDateTime modify;
    private List<ItemDTO> items = new ArrayList<>(); // ItemDTO 리스트로 수정

    public User toEntity(){
        return User.builder()
                .id(this.id)
                .accountId(this.accountId)
                .password(this.password)
                .name(this.name)
                .nickName(this.nickName)
                .phoneNumber(this.phoneNumber)
                .role(UserRole.USER)
                .email(this.email)
                .money(this.money)
                .modify(this.modify)
                .create(this.create)
                .items(this.items.stream().map(ItemDTO::toEntity).collect(Collectors.toList())) // ItemDTO를 Item 엔티티로 변환
                .build();
    }

    public static UserDTO fromEntity(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setAccountId(user.getAccountId());
        dto.setPassword(user.getPassword());
        dto.setName(user.getName());
        dto.setNickName(user.getNickName());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setRole(user.getRole());
        dto.setEmail(user.getEmail());
        dto.setMoney(user.getMoney());
        dto.setModify(user.getModify());
        dto.setCreate(user.getCreate());
        dto.setItems(user.getItems().stream().map(ItemDTO::fromEntity).collect(Collectors.toList())); // Item 엔티티를 ItemDTO로 변환
        return dto;
    }
}
