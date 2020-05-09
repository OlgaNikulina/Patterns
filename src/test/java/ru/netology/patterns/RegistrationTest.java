package ru.netology.patterns;

import com.github.javafaker.Faker;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.dataGenerator.DataGenerator;
import ru.netology.loginPages.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationTest {
    Faker faker;

    @Test
    void shouldSendFormIfValuesCorrect() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue(faker.address().cityName());
        $("span.menu-item__control").click();
        $("[placeholder='Дата встречи']").sendKeys(Keys.CONTROL + "a");
        $("[placeholder='Дата встречи']").sendKeys(Keys.DELETE);
        $("[placeholder='Дата встречи']").setValue(String.valueOf(faker.date()));
        $("[name='name']").setValue(String.valueOf(faker.name()));
        $("[name='phone']").setValue(String.valueOf(faker.phoneNumber()));
        $("span[class='checkbox__text']").click();
        $$("button").find(exactText("Забронировать")).click();
        $("div.notification__title").shouldBe(visible);
    }

    @Test
    void shouldSendFormWithOtherDate() {
        open("http://localhost:9999");
        val loginPage = new LoginPage2();
        val Registration = DataGenerator.getOtherRegistration();
    }

    @Test
    void shouldNotSendFormWithOneEnglishLetterInLocationField() {
        open("http://localhost:9999");
        val loginPage = new LoginPage3();
        val Registration = DataGenerator.getThirdVariantOfRegistration();
    }

    @Test
    void shouldNotSendFormWithInvalidDate() {
        open("http://localhost:9999");
        val loginPage = new LoginPage4();
        val Registration = DataGenerator.getFourthVariantOfRegistration();
    }

    @Test
    void shouldNotSendFormWithOneEnglishLetterInNameField() {
        open("http://localhost:9999");
        val loginPage = new LoginPage5();
        val Registration = DataGenerator.getFifthVariantOfRegistration();
    }

    @Test
    void shouldNotSendFormWithPlusInPhoneField() {
        open("http://localhost:9999");
        val loginPage = new LoginPage6();
        val Registration = DataGenerator.getSixthVariantOfRegistration();
    }

    @Test
    void shouldNotSendFormWithEmptyFields() {
        open("http://localhost:9999");
        val loginPage = new LoginPage7();
        val Registration = DataGenerator.getSeventhVariantOfRegistration();
    }
}
