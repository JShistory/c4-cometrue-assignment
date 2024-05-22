package org.c4marathon.assignment.openMarket.controller;

import lombok.RequiredArgsConstructor;
import org.c4marathon.assignment.openMarket.dto.UserDTO;
import org.c4marathon.assignment.openMarket.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    @GetMapping("/user")
    public String createUser() {

        return "userCreate";
    }


    @PostMapping("/userProc")
    public String createProcess(UserDTO userDTO) {

        System.out.println(userDTO.getAccountId());

        userService.join(userDTO);


        return "redirect:/login";
    }
}
