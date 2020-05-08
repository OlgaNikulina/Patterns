package ru.netology.loginPages.patterns;
import com.github.javafaker.Faker;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.loginPages.*;
import ru.netology.dataGenerator.DataGenerator;

import java.util.Locale;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {
    DataGenerator.Registration registration = new DataGenerator.Registration("", "", "", "");

    @BeforeEach
    void setUpAll() {
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
    }

    @Test
    void shouldTestWithData() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val Registration = DataGenerator.getRegistration();
    }

    @Test
    void shouldTestWithOtherData() {
        open("http://localhost:9999");
        val loginPage = new LoginPage2();
        val Registration = DataGenerator.getOtherRegistration();
    }

    @Test
    void shouldTestWithThirdVariant() {
        open("http://localhost:9999");
        val loginPage = new LoginPage3();
        val Registration = DataGenerator.getThirdVariantOfRegistration();
    }

    @Test
    void shouldTestWithFourthVariant() {
        open("http://localhost:9999");
        val loginPage = new LoginPage4();
        val Registration = DataGenerator.getFourthVariantOfRegistration();
    }

    @Test
    void shouldTestWithFifthVariant() {
        open("http://localhost:9999");
        val loginPage = new LoginPage5();
        val Registration = DataGenerator.getFifthVariantOfRegistration();
    }

    @Test
    void shouldTestWithSixthVariant() {
        open("http://localhost:9999");
        val loginPage = new LoginPage6();
        val Registration = DataGenerator.getSixthVariantOfRegistration();
    }

    @Test
    void shouldTestWithSeventhVariant() {
        open("http://localhost:9999");
        val loginPage = new LoginPage7();
        val Registration = DataGenerator.getSeventhVariantOfRegistration();
    }
}
