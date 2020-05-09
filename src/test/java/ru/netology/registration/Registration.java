package ru.netology.registration;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
@RequiredArgsConstructor
class Registration {
    private final String location;
    private final String date;
    private final String name;
    private final String phone;

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
}
