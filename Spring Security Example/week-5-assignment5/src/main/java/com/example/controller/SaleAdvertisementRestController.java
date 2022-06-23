package com.example.controller;

import com.example.entity.SaleAdvertisement;
import com.example.service.SaleAdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/sale-advertisements")
@RequiredArgsConstructor
@CrossOrigin
@RequestScope
public class SaleAdvertisementRestController {

    private final SaleAdvertisementService saleAdvertisementService;


    @GetMapping("/request")
    public ResponseEntity<String> createAdvertisementConsumerRequest(@RequestParam Integer custom) {
        saleAdvertisementService.createAdvertisement(custom);
        return ResponseEntity.ok("Your request added to queue");
    }

    @GetMapping("/find-by-price")
    public List<SaleAdvertisement> getAdvertisementByPrice(@RequestParam Double minPrice,
                                                           @RequestParam Double maxPrice) {
        return saleAdvertisementService.getAdvertisementByPrice(minPrice, maxPrice);
    }

    @GetMapping("/find-by-word")
    public List<SaleAdvertisement> getSaleAdvertisementByWord(@RequestParam String word) {
        return saleAdvertisementService.findSaleAdvertisementByWord(word);
    }

    @GetMapping("/find-latest-by-userPk-and-custom")
    public List<SaleAdvertisement> findLatestAdvertisementsByUserPkAndCustom(@RequestParam String userPk, @RequestParam Integer custom) {
        return saleAdvertisementService.findLatestAdvertisementsByUserPkAndCustom(userPk, custom);

    }
}
