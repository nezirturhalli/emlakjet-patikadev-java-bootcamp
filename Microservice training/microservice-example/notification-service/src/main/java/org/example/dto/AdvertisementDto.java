package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementDto {
    private String advertisementId;
    private Long userId;
    private String title;
    private String detailMessage;
    private BigDecimal price;
}
