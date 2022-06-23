package com.example.consumer;

import com.example.service.SaleAdvertisementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SaleAdvertisementConsumer {
    SaleAdvertisementService saleAdvertisementService;

    @RabbitListener(queues = "${saleAdvertisement-queue.name}")
    private void saveSaleAdvertisement(Integer custom) throws InterruptedException {
        log.info("Consumer generated random sale advertisements");
        //Thread.sleep(2L * 1000);
        saleAdvertisementService.createAdvertisement(custom);

    }
}
