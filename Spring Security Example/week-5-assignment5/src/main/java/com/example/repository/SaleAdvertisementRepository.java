package com.example.repository;

import com.example.entity.SaleAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleAdvertisementRepository extends JpaRepository<SaleAdvertisement, String> {
    List<SaleAdvertisement> findByPriceBetween(Double minPrice, Double maxPrice);

    List<SaleAdvertisement> findByTitleContains(String word);

    List<SaleAdvertisement> findByDescriptionContains(String word);

    List<SaleAdvertisement> findByUserUserPk(String userPk);
}
