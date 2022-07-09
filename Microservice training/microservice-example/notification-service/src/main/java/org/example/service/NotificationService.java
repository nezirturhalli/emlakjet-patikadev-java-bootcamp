package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.AdvertisementDto;
import org.example.entity.Notification;
import org.example.entity.NotificationState;
import org.example.repository.NotificationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final NotificationRepository notificationRepository;

    @RabbitListener(queues = "${queue.name}")
    public void consumer(@Payload AdvertisementDto advertisementDto) {

        var notification = new Notification();
        notification.setUserId(advertisementDto.getUserId());
        notification.setAdvertisementId(advertisementDto.getAdvertisementId());
        notification.setMessage(advertisementDto.getDetailMessage());
        notification.setCreatedAt(LocalDateTime.now());
        notification.setState(NotificationState.SENT);
        log.info("Sent notification!");
        notificationRepository.save(notification);

    }
}
