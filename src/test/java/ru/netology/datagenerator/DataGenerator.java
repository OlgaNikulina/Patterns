package ru.netology.datagenerator;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

@Data
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

    static String dateSet() {
        LocalDate dates = LocalDate.now();
        LocalDate localDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        localDate = dates.plusDays(3);
        String futureDate = formatter.format(localDate.plusDays(3));
        return futureDate;
    }

    static String otherDateSet() {
        LocalDate dates = LocalDate.now();
        LocalDate localDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        localDate = dates.plusDays(5);
        String futureDate = formatter.format(localDate.plusDays(5));
        return futureDate;
    }

    static String generateRandomLocation() {
        String[] cities = new String[]{"Москва", "Волгоград", "Воронеж"};
        Random random = new Random();
        int index = random.nextInt(cities.length - 1);
        return cities[index];
    }

    static String generateRandomName() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    static String generateRandomPhone() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().phoneNumber();
    }

    public static Registration getRegistration() {
        return new Registration(generateRandomLocation(), dateSet(), generateRandomName(), generateRandomPhone());
    }

    public static Registration getRegistrationWithOtherDate() {
        return new Registration(generateRandomLocation(), otherDateSet(), generateRandomName(), generateRandomPhone());
    }


    public static Registration getRegistrationWithEmptyFields() {
        return new Registration("", "", "", "");
    }

    public static Registration getRegistrationWithOneEnglishLetterInLocationField() {
        return new Registration("L", dateSet(), generateRandomName(), generateRandomPhone());
    }

    public static Registration getRegistrationWithInvalidDate() {
        return new Registration(generateRandomLocation(), "09-05-2020", generateRandomName(), generateRandomPhone());
    }

    public static Registration getRegistrationWithOneEnglishLetterInNameField() {
        return new Registration(generateRandomLocation(), dateSet(), "L", generateRandomPhone());
    }

    public static Registration getRegistrationWithPlusInPhoneField() {
        return new Registration(generateRandomLocation(), dateSet(), generateRandomName(), "+");
    }
}
