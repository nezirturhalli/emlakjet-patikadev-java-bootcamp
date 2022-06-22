package com.example.service.impl;

import com.example.entity.SaleAdvertisement;
import com.example.repository.SaleAdvertisementRepository;
import com.example.repository.UserRepository;
import com.example.service.SaleAdvertisementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static com.example.helper.DescriptionHelper.generateDescription;
import static com.example.helper.TitleHelper.generateTitle;

@Service
@Slf4j
@RequiredArgsConstructor
public class SaleAdvertisementServiceImpl implements SaleAdvertisementService {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;
    private final UserRepository userRepository;
    private final SaleAdvertisementRepository saleAdvertisementRepository;
    Random random;

    @Override
    public void createAdvertisementConsumerRequest(Integer custom) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "sale advertisement routingKey", custom);

    }

    @Override
    public void createAdvertisement(Integer custom) {

        for (int i = 0; i < custom; i++) {
            SaleAdvertisement saleAdvertisement = SaleAdvertisement.builder()
                    .userPk(getRandomUserPk())
                    .title(generateTitle())
                    .description(generateDescription())
                    .price(random.nextDouble(3000000.00))
                    .createdAt(LocalDateTime.now())
                    .build();
            saleAdvertisementRepository.save(saleAdvertisement);
        }

    }

    @Override
    public List<SaleAdvertisement> getAdvertisementByPrice(Double minPrice, Double maxPrice) {
        return saleAdvertisementRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<SaleAdvertisement> findSaleAdvertisementByWord(String word) {

        List<SaleAdvertisement> saleAdvertisementList = new ArrayList<>();
        saleAdvertisementList.addAll(saleAdvertisementRepository.findByTitleContains(word));
        saleAdvertisementList.addAll(saleAdvertisementRepository.findByDescriptionContains(word));
        return saleAdvertisementList.stream()
                .sorted(Comparator.comparing(SaleAdvertisement::getCreatedAt).reversed())
                .toList();

    }

    @Override
    public List<SaleAdvertisement> findLatestAdvertisementsByUserPkAndCustom(Long userPk, Integer custom) {
        var saleAdvertisementFindByUserPkList = saleAdvertisementRepository.findByUserUserPk(userPk);
        return saleAdvertisementFindByUserPkList.stream()
                .sorted(Comparator.comparing(SaleAdvertisement::getCreatedAt).reversed())
                .limit(custom)
                .toList();
    }

    private Long getRandomUserPk() {
        return userRepository.getRandomUser().getUserPk();
    }
}
