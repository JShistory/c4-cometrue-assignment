package org.c4marathon.assignment.openMarket.controller;

import lombok.RequiredArgsConstructor;
import org.c4marathon.assignment.openMarket.domain.User;
import org.c4marathon.assignment.openMarket.dto.ItemDTO;
import org.c4marathon.assignment.openMarket.dto.UserDTO;
import org.c4marathon.assignment.openMarket.service.ItemService;
import org.c4marathon.assignment.openMarket.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/item")
@Controller
public class ItemController {
    private final ItemService itemService;
    private final UserService userService;
    @GetMapping("/itemList")
    public String items(Model model){
        var itemList = itemService.findAll();
        System.out.println("itemList : " + itemList);
        model.addAttribute("items",itemList);
        return "itemList";
    }
    @GetMapping("/itemForm")
    public String showItemForm() {
        return "itemCreate";
    }

    @PostMapping("/itemForm")
    public String addItem(ItemDTO item) {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByAccountId(id);
        UserDTO userDTO = UserDTO.fromEntity(user);

        itemService.saveItem(item,userDTO.getId());
        return "redirect:/item/itemList";
    }
}
