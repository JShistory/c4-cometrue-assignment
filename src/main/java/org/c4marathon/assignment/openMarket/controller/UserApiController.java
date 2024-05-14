package org.c4marathon.assignment.openMarket.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.c4marathon.assignment.openMarket.domain.User;
import org.c4marathon.assignment.openMarket.dto.UserDTO;
import org.c4marathon.assignment.openMarket.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class UserApiController {
    private final UserService userService;
    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody @Valid UserDTO user){
        Long userId = userService.join(user);
        return ResponseEntity
                .ok()
                .body(userId);
    }
}
