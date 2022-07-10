package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.AdvertisementDto;
import org.example.service.AdvertisementService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/advertisement")
@CrossOrigin
@RequestScope
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @PostMapping("/create-advertisement")
    public String createNewAdvertisement(@RequestBody AdvertisementDto advertisementDto) {
        advertisementService.createNewAdvertisement(advertisementDto);
        return "Your request has been sent.";
    }

}
