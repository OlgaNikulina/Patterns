package ru.netology.loginpages;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;


@Value
public class LoginPage {

    private SelenideElement cityField = $("[placeholder='Город']");
    private SelenideElement menuItem = $("span.menu-item__control");
    private SelenideElement dateField = $("[placeholder='Дата встречи']");
    private SelenideElement nameField = $("[name='name']");
    private SelenideElement phoneField = $("[name='phone']");
    private SelenideElement checkBox = $("span[class='checkbox__text']");
    private SelenideElement button = $$("button").find(exactText("Запланировать"));
    private SelenideElement successNotification = $("div.notification__title");
    private SelenideElement getNotificationRequiredField = $("[data-test-id='city'] .input__sub");
    private SelenideElement getNotificationDeliveryUnavailable = $("[data-test-id='city'] .input__sub");
    private SelenideElement getNotificationOrderWithDateIsNotPossible = $("[data-test-id='date'] .input__sub");
    private SelenideElement getNotificationNameIncorrect = $("[data-test-id='name'] .input__sub");
    private SelenideElement getNotificationNumberIncorrect = $$("error").find(exactText("Номер телефона введем некорректно"));
    private SelenideElement getNotificationOverride = $("div.notification__title");
    private SelenideElement overrideButton = $$("button").find(exactText("Перепланировать"));
    private SelenideElement getSuccessNotificationOverride = $("div.notification__title");
}
