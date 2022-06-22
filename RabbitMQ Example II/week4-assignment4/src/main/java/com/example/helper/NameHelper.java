package com.example.helper;

import java.util.List;
import java.util.Random;

public class NameHelper {

    private NameHelper() {
    }

    public static String generateName() {
        Random random = new Random();
        List<String> userNames = List.of("Ali", "Zeynep", "Ahmet", "Veli", "Burak");
        return userNames.get(random.nextInt(userNames.size()));

    }
}
