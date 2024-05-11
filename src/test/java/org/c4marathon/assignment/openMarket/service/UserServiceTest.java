package org.c4marathon.assignment.openMarket.service;

import static org.junit.jupiter.api.Assertions.*;

import org.c4marathon.assignment.openMarket.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void userDuplicate(){
        //given
        User user1 = User.builder()
                .name("김재성")
                .accountId("test")
                .build();

        User user2 = User.builder()
                .name("김홍길")
                .accountId("test")
                .build();
        //when
        userService.join(user1);
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> {
           userService.join(user2);
        });
    }
}