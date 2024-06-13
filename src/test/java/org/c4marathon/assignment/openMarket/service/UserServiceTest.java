package org.c4marathon.assignment.openMarket.service;

import static org.junit.jupiter.api.Assertions.*;

import org.c4marathon.assignment.openMarket.domain.Cart;
import org.c4marathon.assignment.openMarket.domain.Item;
import org.c4marathon.assignment.openMarket.domain.User;
import org.c4marathon.assignment.openMarket.dto.ItemDTO;
import org.c4marathon.assignment.openMarket.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    ItemService itemService;
    @Autowired
    CartService cartService;
    @Transactional
    @DisplayName("중복_회원_가입_예외_테스트")
    @Test
    public void userDuplicate() {
        var cart = cartService.CartCreate();
        //given
        var user1 = new UserDTO();
        user1.setName("김재성");
        user1.setAccountId("test");
        user1.setPassword("1234");

        var user2 = new UserDTO();
        user2.setName("김홍동");
        user2.setAccountId("test");
        user2.setPassword("1234");
        //when
        userService.join(user1, cart);
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            userService.join(user2, cart);
        });
    }
    @Transactional
    @DisplayName("자신이_등록한_아이템은_구매할수없다")
    @Test
    public void myselfItem() {
        var cart = cartService.CartCreate();
        //given
        var userDTO = new UserDTO();
        userDTO.setName("김재성");
        userDTO.setAccountId("KJS");
        userDTO.setPassword("1234");
        Long userId = userService.join(userDTO, cart);
        User user = userService.findOne(userId);

        var item = new ItemDTO();
        item.setUserId(user.getId());
        item.setName("애플워치");
        item.setAmount(1);
        item.setPrice(300000L);
        itemService.saveItem(item, user);




        //when
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            userService.buyItem(user,item.toEntity());
        });
    }
}