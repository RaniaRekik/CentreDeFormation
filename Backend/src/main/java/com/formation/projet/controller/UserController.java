package com.formation.projet.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController

@RequestMapping("/user")
public class UserController {
    @GetMapping("/allusers")
    public String displayUsers() {
        return "Accès libre";
    }

    @GetMapping("/displayuser")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String displayToUser() {
        return "Cette partie est reservée aux comptes user et admin";
    }

    @GetMapping("/displayadmin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String displayToAdmin() {
        return "Cette partie est reservée à l'adminstrateur";
    }
}