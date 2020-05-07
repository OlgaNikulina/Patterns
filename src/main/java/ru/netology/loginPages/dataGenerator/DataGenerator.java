package ru.netology.loginPages.dataGenerator;

import lombok.Value;

public class DataGenerator {
    private DataGenerator() {
    }

    @Value
    public static class Registration {
        String location;
        String date;
        String name;
        String phone;
    }

    public static Registration getRegistration() {
        return new Registration("Москва", "11-05-2020", "Александр Михайлов", "+79123654789");
    }

    public static Registration getOtherRegistration() {
        return new Registration("Москва", "12-05-2020", "Александр Михайлов", "+79123654789");
    }
}
