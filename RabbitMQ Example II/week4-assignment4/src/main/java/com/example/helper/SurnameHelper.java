package com.example.helper;

import java.util.List;
import java.util.Random;

public class SurnameHelper {
    private SurnameHelper() {
    }

    public static String generateSurname() {
        Random random = new Random();
        List<String> userSurnames = List.of("Tez", "Almaz", "Vural", "Terim", "Mutlu");
        return userSurnames.get(random.nextInt(userSurnames.size()));

    }
}
