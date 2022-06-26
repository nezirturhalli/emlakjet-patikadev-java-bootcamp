package com.example.consumer;

import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserConsumer {
    private final UserService userService;

    public UserConsumer(UserService userService) {
        this.userService = userService;
    }

    @RabbitListener(queues = "${user-queue.name}")
    private void saveUser(Integer custom) throws InterruptedException {
        log.info("Consumer generated random users");
        Thread.sleep(2000);
        userService.createUser(custom);
    }
}
