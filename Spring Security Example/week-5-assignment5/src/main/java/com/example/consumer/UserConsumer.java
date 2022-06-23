package com.example.consumer;

import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserConsumer {
    private final UserService userService;

    @RabbitListener(queues = "${user-queue.name}")
    public void saveUser() throws InterruptedException {
        log.info("Consumer generated random users");
        //Thread.sleep(2L * 1000);
        userService.createUser(50);
    }
}
