package ru.netology.patterns;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class RegistrationTest {
    private Faker faker;

    @BeforeEach
    void setUpAll(){
        faker = new Faker(new Locale("ru"));
    }

    @Test
    void shouldTest(){
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();



    }
}
