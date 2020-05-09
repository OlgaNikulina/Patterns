package ru.netology.dataGenerator;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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

    void dateSet() {
        LocalDate dates = LocalDate.now();
        LocalDate localDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        localDate = dates.plusDays(3);
        String futureDate = formatter.format(localDate.plusDays(3));
    }

    void fakerSet() {
        Faker faker = new Faker(new Locale("ru"));
        String location = faker.address().cityName();
        DateAndTime date = faker.date();
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
    }

    public static Registration getRegistration() {
        return new Registration("Москва", "11-05-2020", "Александр Михайлов", "+79123654789");
    }

    public static Registration getOtherRegistration() {
        return new Registration("Москва", "12-05-2020", "Александр Михайлов", "+79123654789");
    }

    public static Registration getThirdVariantOfRegistration() {
        return new Registration("L", "12-05-2020", "Александр Михайлов", "+79123654789");
    }

    public static Registration getFourthVariantOfRegistration() {
        return new Registration("Москва", "24.25.4242", "Александр Михайлов", "+79123654789");
    }

    public static Registration getFifthVariantOfRegistration() {
        return new Registration("Москва", "12-05-2020", "L", "+79123654789");
    }

    public static Registration getSixthVariantOfRegistration() {
        return new Registration("Москва", "12-05-2020", "Александр Михайлов", "+");
    }

    public static Registration getSeventhVariantOfRegistration() {
        return new Registration("", "", "", "");
    }
}
