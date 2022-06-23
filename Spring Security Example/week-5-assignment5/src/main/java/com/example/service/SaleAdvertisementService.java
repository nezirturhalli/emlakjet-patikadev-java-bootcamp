package com.example.service;

import com.example.entity.SaleAdvertisement;

import java.util.List;

public interface SaleAdvertisementService {


    void createAdvertisement(Integer custom);

    List<SaleAdvertisement> getAdvertisementByPrice(Double minPrice, Double maxPrice);

    List<SaleAdvertisement> findSaleAdvertisementByWord(String word);

    List<SaleAdvertisement> findLatestAdvertisementsByUserPkAndCustom(String userPk, Integer custom);


}
