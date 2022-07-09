package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.AdvertisementDto;
import org.example.entity.Advertisement;
import org.example.repository.AdvertisementRepository;
import org.example.service.AdvertisementService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @Override
    public void createNewAdvertisement(AdvertisementDto advertisementDto) {
        var advertisement = new Advertisement();
        advertisement.setUserId(advertisementDto.getUserId());
        advertisement.setTitle(advertisementDto.getTitle());
        advertisement.setDetailMessage(advertisementDto.getDetailMessage());
        advertisement.setPrice(advertisementDto.getPrice());
        advertisement.setCreatedAt(LocalDateTime.now());
        advertisementRepository.save(advertisement);
        rabbitTemplate.convertAndSend(queue.getName(), advertisementDto);
        log.info("Sent advertisement request!");

    }
}
