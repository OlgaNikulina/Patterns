package ru.netology.patterns;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.datagenerator.DataGenerator;
import ru.netology.loginpages.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldSendFormIfValuesCorrect() {
        LoginPage loginPage = new LoginPage();
        DataGenerator.Registration dataGenerator = DataGenerator.getRegistration();
        open("http://localhost:9999");
        loginPage.getCityField().setValue(dataGenerator.getLocation());
        loginPage.getMenuItem().click();
        loginPage.getDateField().sendKeys(Keys.CONTROL + "a");
        loginPage.getDateField().sendKeys(Keys.DELETE);
        loginPage.getDateField().setValue(dataGenerator.getDate());
        loginPage.getNameField().setValue(dataGenerator.getName());
        loginPage.getPhoneField().setValue(dataGenerator.getPhone());
        loginPage.getCheckBox().click();
        loginPage.getButton().click();
        loginPage.getSuccessNotification().shouldBe(visible);
    }

    @Test
    void shouldSendFormWithOtherDate() {
        LoginPage loginPage = new LoginPage();
        DataGenerator.Registration dataGenerator = DataGenerator.getRegistration();
        open("http://localhost:9999");
        loginPage.getCityField().setValue(dataGenerator.getLocation());
        loginPage.getMenuItem().click();
        loginPage.getDateField().sendKeys(Keys.CONTROL + "a");
        loginPage.getDateField().sendKeys(Keys.DELETE);
        loginPage.getDateField().setValue(dataGenerator.getDate());
        loginPage.getNameField().setValue(dataGenerator.getName());
        loginPage.getPhoneField().setValue(dataGenerator.getPhone());
        loginPage.getCheckBox().click();
        loginPage.getButton().click();
        loginPage.getSuccessNotification().shouldBe(visible);
        DataGenerator.Registration dataGenerator1 = DataGenerator.getRegistrationWithOtherDate();
        loginPage.getDateField().sendKeys(Keys.CONTROL + "a");
        loginPage.getDateField().sendKeys(Keys.DELETE);
        loginPage.getDateField().setValue(dataGenerator.getDate());
        loginPage.getButton().click();
        loginPage.getGetNotificationOverride().shouldBe(visible);
        loginPage.getOverrideButton().click();
        loginPage.getGetSuccessNotificationOverride().shouldBe(visible);
    }

    @Test
    void shouldSendFormWithEmptyFields() {
        LoginPage loginPage = new LoginPage();
        DataGenerator.Registration dataGenerator = DataGenerator.getRegistrationWithEmptyFields();
        open("http://localhost:9999");
        loginPage.getCityField().setValue(dataGenerator.getLocation());
        loginPage.getCityField().sendKeys(Keys.TAB);
        loginPage.getDateField().sendKeys(Keys.CONTROL + "a");
        loginPage.getDateField().sendKeys(Keys.DELETE);
        loginPage.getDateField().setValue(dataGenerator.getDate());
        loginPage.getDateField().sendKeys(Keys.TAB);
        loginPage.getNameField().setValue(dataGenerator.getName());
        loginPage.getNameField().sendKeys(Keys.TAB);
        loginPage.getPhoneField().setValue(dataGenerator.getPhone());
        loginPage.getPhoneField().sendKeys(Keys.TAB);
        loginPage.getCheckBox().click();
        loginPage.getButton().click();
        loginPage.getGetNotificationRequiredField().shouldBe(visible);
    }

    @Test
    void shouldNotSendFormWithOneEnglishLetterInLocationField() {
        LoginPage loginPage = new LoginPage();
        DataGenerator.Registration dataGenerator = DataGenerator.getRegistrationWithOneEnglishLetterInLocationField();
        open("http://localhost:9999");
        loginPage.getCityField().setValue(dataGenerator.getLocation());
        loginPage.getCityField().sendKeys(Keys.TAB);
        loginPage.getDateField().sendKeys(Keys.CONTROL + "a");
        loginPage.getDateField().sendKeys(Keys.DELETE);
        loginPage.getDateField().setValue(dataGenerator.getDate());
        loginPage.getNameField().setValue(dataGenerator.getName());
        loginPage.getPhoneField().setValue(dataGenerator.getPhone());
        loginPage.getCheckBox().click();
        loginPage.getButton().click();
        loginPage.getGetNotificationDeliveryUnavailable().shouldBe(visible);
    }

    @Test
    void shouldNotSendFormWithInvalidDate() {
        LoginPage loginPage = new LoginPage();
        DataGenerator.Registration dataGenerator = DataGenerator.getRegistrationWithInvalidDate();
        open("http://localhost:9999");
        loginPage.getCityField().setValue(dataGenerator.getLocation());
        loginPage.getMenuItem().click();
        loginPage.getDateField().sendKeys(Keys.CONTROL + "a");
        loginPage.getDateField().sendKeys(Keys.DELETE);
        loginPage.getDateField().setValue(dataGenerator.getDate());
        loginPage.getNameField().setValue(dataGenerator.getName());
        loginPage.getPhoneField().setValue(dataGenerator.getPhone());
        loginPage.getCheckBox().click();
        loginPage.getButton().click();
        loginPage.getGetNotificationOrderWithDateIsNotPossible().shouldBe(visible);
    }

    @Test
    void shouldNotSendFormWithOneEnglishLetterInNameField() {
        LoginPage loginPage = new LoginPage();
        DataGenerator.Registration dataGenerator = DataGenerator.getRegistrationWithOneEnglishLetterInNameField();
        open("http://localhost:9999");
        loginPage.getCityField().setValue(dataGenerator.getLocation());
        loginPage.getMenuItem().click();
        loginPage.getDateField().sendKeys(Keys.CONTROL + "a");
        loginPage.getDateField().sendKeys(Keys.DELETE);
        loginPage.getDateField().setValue(dataGenerator.getDate());
        loginPage.getNameField().setValue(dataGenerator.getName());
        loginPage.getPhoneField().setValue(dataGenerator.getPhone());
        loginPage.getCheckBox().click();
        loginPage.getButton().click();
        loginPage.getGetNotificationNameIncorrect().shouldBe(visible);
    }

    @Test
    void shouldNotSendFormWithPlusInPhoneField() {
        LoginPage loginPage = new LoginPage();
        DataGenerator.Registration dataGenerator = DataGenerator.getRegistrationWithPlusInPhoneField();
        open("http://localhost:9999");
        loginPage.getCityField().setValue(dataGenerator.getLocation());
        loginPage.getMenuItem().click();
        loginPage.getDateField().sendKeys(Keys.CONTROL + "a");
        loginPage.getDateField().sendKeys(Keys.DELETE);
        loginPage.getDateField().setValue(dataGenerator.getDate());
        loginPage.getNameField().setValue(dataGenerator.getName());
        loginPage.getPhoneField().setValue(dataGenerator.getPhone());
        loginPage.getCheckBox().click();
        loginPage.getButton().click();
        loginPage.getGetNotificationNumberIncorrect().shouldBe(visible);
    }
}
