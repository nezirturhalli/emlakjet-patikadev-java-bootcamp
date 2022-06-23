package com.example.controller;

import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
@RequestScope
public class UserRestController {
    private final UserService userService;

    @GetMapping("/request")
    public ResponseEntity<String> createUserConsumerRequest(@RequestParam Integer custom) {
        userService.createUser(custom);
        return ResponseEntity.ok("Your request added to queue");
    }
}
