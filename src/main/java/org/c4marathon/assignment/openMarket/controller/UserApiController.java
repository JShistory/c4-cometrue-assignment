package org.c4marathon.assignment.openMarket.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.c4marathon.assignment.openMarket.domain.Item;
import org.c4marathon.assignment.openMarket.domain.User;
import org.c4marathon.assignment.openMarket.dto.ItemDTO;
import org.c4marathon.assignment.openMarket.dto.UserDTO;
import org.c4marathon.assignment.openMarket.service.ItemService;
import org.c4marathon.assignment.openMarket.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class UserApiController {
    private final UserService userService;
    private final ItemService itemService;
    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody @Valid UserDTO user){
        Long userId = userService.join(user);
        return ResponseEntity
                .ok()
                .body(userId);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity userOne(@PathVariable("id") Long id){
        UserDTO user = userService.findOne(id);
        return ResponseEntity.ok()
                .body(user);
    }

    @PostMapping("/users/{id}/items")
    public ResponseEntity createItem(@RequestBody @Valid ItemDTO item, @PathVariable("id") Long id){
        Long saveItem = itemService.saveItem(item, id);
        return ResponseEntity.ok()
                .body(saveItem);
    }
    @GetMapping("/users/{id}/items/{item_id}")
    public ResponseEntity createItem(@PathVariable("id") Long id, @PathVariable("item_id") Long itemId){
        UserDTO user = userService.findOne(id);
        List<Item> items = user.getItems();
        for(Item data : items){
            if(data.getId().equals(itemId)){
                return ResponseEntity.ok()
                        .body(data);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/items")
    public ResponseEntity items(){
        List<Item> itemList = itemService.findAll();
        if(itemList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(itemList);
    }
}
