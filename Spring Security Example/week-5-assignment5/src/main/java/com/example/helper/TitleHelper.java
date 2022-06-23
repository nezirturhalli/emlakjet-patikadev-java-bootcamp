package com.example.helper;

import java.util.List;
import java.util.Random;

public class TitleHelper {

    private TitleHelper() {
    }

    public static String generateTitle() {
        Random random = new Random();
        List<String> titleOne = List.of("satılık", "kiralık", "temiz","doktordan");
        List<String> titleTwo = List.of("ev", "araba", "arsa", "villa");
        return titleOne.get(random.nextInt(titleOne.size())) + " " + titleOne.get(random.nextInt(titleTwo.size()));

    }

}
