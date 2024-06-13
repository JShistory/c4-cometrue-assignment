//package org.c4marathon.assignment.openMarket.controller;
//
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.c4marathon.assignment.openMarket.domain.Item;
//import org.c4marathon.assignment.openMarket.domain.User;
//import org.c4marathon.assignment.openMarket.dto.ItemDTO;
//import org.c4marathon.assignment.openMarket.dto.LoginDTO;
//import org.c4marathon.assignment.openMarket.dto.UserDTO;
//import org.c4marathon.assignment.openMarket.service.ItemService;
//import org.c4marathon.assignment.openMarket.service.UserService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.security.core.Authentication;
//
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//
//@RequiredArgsConstructor
//@RequestMapping("/api/v1")
//@RestController
//public class UserApiController {
//    private final UserService userService;
//    private final ItemService itemService;
//    @PostMapping("/users")
//    public ResponseEntity createUser(@RequestBody @Valid UserDTO user){
//        Long userId = userService.join(user);
//        return ResponseEntity
//                .ok()
//                .body(userId);
//    }
//
//    @GetMapping("/users")
//    public ResponseEntity user(){
//        String id = SecurityContextHolder.getContext().getAuthentication().getName();
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
//        GrantedAuthority auth = iter.next();
//        String role = auth.getAuthority();
//        return ResponseEntity
//                .ok()
//                .body(role);
//    }
//
//    @GetMapping("/users/{id}")
//    public ResponseEntity userOne(@PathVariable("id") Long id){
//        User user = userService.findOne(id);
//        UserDTO userDTO = UserDTO.fromEntity(user);
//        return ResponseEntity.ok()
//                .body(userDTO);
//    }
//
////    @PostMapping("/users/login")
////    public ResponseEntity login(LoginDTO loginDTO){
////
////    }
//
//    @PostMapping("/users/{id}/items")
//    public ResponseEntity createItem(@RequestBody @Valid ItemDTO item, @PathVariable("id") Long id){
//        Long saveItem = itemService.saveItem(item, id);
//        return ResponseEntity.ok()
//                .body(saveItem);
//    }
//    @GetMapping("/users/{id}/items/{item_id}")
//    public ResponseEntity createItem(@PathVariable("id") Long id, @PathVariable("item_id") Long itemId){
//        User user = userService.findOne(id);
//        UserDTO userDTO = UserDTO.fromEntity(user);
//        List<ItemDTO> items = userDTO.getItems();
//        for(ItemDTO data : items){
//            if(data.getId().equals(itemId)){
//                return ResponseEntity.ok()
//                        .body(data);
//            }
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//
//}
