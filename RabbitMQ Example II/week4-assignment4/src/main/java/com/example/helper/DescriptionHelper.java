package com.example.helper;

import java.util.List;
import java.util.Random;

public class DescriptionHelper {
    private DescriptionHelper() {
    }

    public static String generateDescription() {
        List<String> description = List.of(
                "İhtiyaçtan Satılık",
                "Asansörlü",
                "Kombili",
                "Bu Fiyata Bu Evi Bir Daha Bulamazsınız",
                "Fiber Altyapılı",
                "Acun Emlak",
                "Kalite Güven Bizim İşimiz",
                "Akıllı Ev Sistemi",
                "Yerden Isıtma");
        Random random = new Random();
        return description.get(random.nextInt(description.size()));
    }
}
