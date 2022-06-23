package com.example.helper;

import java.util.Locale;

import static com.example.helper.NameHelper.generateName;
import static com.example.helper.SurnameHelper.generateSurname;

public class EmailHelper {

    private EmailHelper() {
    }

    public static String generateEmail() {
        return (generateName() + "." + generateSurname() + "@mail.com").toLowerCase(Locale.ROOT);

    }
}
