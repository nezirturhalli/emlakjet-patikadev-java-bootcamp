package org.example.service;

import org.example.dto.request.AddUserRequest;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService  {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(@Lazy UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public User addNewUser(AddUserRequest addUserRequest) {
        var user = new User();
        user.setUsername(addUserRequest.getUsername());
        user.setFullname(addUserRequest.getFullname());
        user.setPassword(passwordEncoder.encode(addUserRequest.getPassword()));
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);

    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }



}
