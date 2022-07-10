package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.AddUserRequest;
import org.example.dto.request.LoginUserRequest;
import org.example.entity.User;
import org.example.service.AuthenticationService;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RequestMapping("/auth")
@RestController
@RequestScope
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody AddUserRequest user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.addNewUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginUserRequest user) {

        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }


    @GetMapping("/findAllUsers")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAllUsers());
    }
}

