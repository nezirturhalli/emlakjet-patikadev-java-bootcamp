package com.example.service;

import com.example.entity.SaleAdvertisement;

import java.util.List;

public interface SaleAdvertisementService {

    void createAdvertisementConsumerRequest(Integer custom);

    void createAdvertisement(Integer custom);

    List<SaleAdvertisement> getAdvertisementByPrice(Double minPrice, Double maxPrice);

    List<SaleAdvertisement> findSaleAdvertisementByWord(String word);

    List<SaleAdvertisement> findLatestAdvertisementsByUserPkAndCustom(Long userPk, Integer custom);


}
