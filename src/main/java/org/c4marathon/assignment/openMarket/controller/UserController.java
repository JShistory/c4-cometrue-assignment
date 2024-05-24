package org.c4marathon.assignment.openMarket.controller;

import lombok.RequiredArgsConstructor;
import org.c4marathon.assignment.openMarket.domain.Cart;
import org.c4marathon.assignment.openMarket.domain.Item;
import org.c4marathon.assignment.openMarket.domain.User;
import org.c4marathon.assignment.openMarket.dto.ItemDTO;
import org.c4marathon.assignment.openMarket.dto.UserDTO;
import org.c4marathon.assignment.openMarket.service.CartService;
import org.c4marathon.assignment.openMarket.service.ItemService;
import org.c4marathon.assignment.openMarket.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final ItemService itemService;
    private final CartService cartService;
    @GetMapping("/user")
    public String createUser() {
        return "userCreate";
    }


    @PostMapping("/userProc")
    public String createProcess(UserDTO userDTO) {
        System.out.println(userDTO.getAccountId());
        Cart cart = cartService.CartCreate();
        userService.join(userDTO, cart);

        return "redirect:/";
    }

    @PostMapping("/user/item/{itemId}")
    public String buyItem(@PathVariable Long itemId){
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByAccountId(id);
        Item item = itemService.findById(itemId);
        userService.buyItem(user,item);

        return "redirect:/";
    }

    @PostMapping("/user/addItem/{itemId}")
    public String addItem(@PathVariable Long itemId){
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByAccountId(id);
        Item item = itemService.findById(itemId);
        user.getCart().addItem(item);
        return "redirect:/item/itemList";
    }

    @GetMapping("/user/cart")
    public String cart(Model model){
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByAccountId(id);
        System.out.println("Cart :"+ user.getCart().getItems());
        System.out.println("Cart2 :"+ user.getCart());
        Cart cart = user.getCart();
        model.addAttribute("cart",cart);
        return "cart";
    }
}
