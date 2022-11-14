package com.example.blog.controlller;

import com.example.blog.security.service.UserAuth;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String hello() {
        UserAuth user  = (UserAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello World "+user.getFirst_name()+", your id is : "+user.getId()+", your role is "+user.getRoles();
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        UserAuth user  = (UserAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello World Admin "+user.getUsername()+", your id is : "+user.getId()+", your role is "+user.getRoles();
    }
}
