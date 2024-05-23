package org.c4marathon.assignment.openMarket.controller;

import lombok.RequiredArgsConstructor;
import org.c4marathon.assignment.openMarket.dto.UserDTO;
import org.c4marathon.assignment.openMarket.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Iterator;
@RequiredArgsConstructor
@Controller
public class HomeController {
    private final UserService userService;
    @GetMapping("/")
    public String home(Model model){
//        String id = SecurityContextHolder.getContext().getAuthentication().getName();
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDTO user = userService.findByAccountId(id);
//
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
//        GrantedAuthority auth = iter.next();
//        String role = auth.getAuthority();
//        model.addAttribute("id",id);
//        model.addAttribute("role",role);
//        model.addAttribute("money",user.getMoney());
        return "main";
    }

}
