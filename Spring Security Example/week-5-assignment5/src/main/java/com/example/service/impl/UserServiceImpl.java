package com.example.service.impl;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.example.helper.EmailHelper.generateEmail;
import static com.example.helper.NameHelper.generateName;
import static com.example.helper.SurnameHelper.generateSurname;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;
    private final UserRepository userRepository;


    @Override
    public void createUser(Integer custom) {
        for (int i = 0; i < custom; i++) {
            User createdUser = User.builder()
                    .userPk(UUID.randomUUID().toString())
                    .name(generateName())
                    .surname(generateSurname())
                    .email(generateEmail())
                    .build();
            log.info("created user: " + createdUser);
            var advToRabbit = userRepository.save(createdUser);
            rabbitTemplate.convertAndSend(directExchange.getName(), advToRabbit);
        }

    }


}
