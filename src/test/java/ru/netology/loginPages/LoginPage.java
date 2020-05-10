package ru.netology.loginPages;

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
    private SelenideElement getNotificationRequiredField = $("#root > div > form > fieldset > div:nth-child(1) > div > span > span > span.input__sub");
    private SelenideElement getNotificationDeliveryUnavailable = $("#root > div > form > fieldset > div:nth-child(1) > div > span > span > span.input__sub");
    private SelenideElement getNotificationOrderWithDateIsNotPossible = $("#root > div > form > fieldset > div:nth-child(2) > span > span > span > span > span.input__sub");
    private SelenideElement getNotificationNameIncorrect = $("#root > div > form > fieldset > div:nth-child(3) > span > span > span.input__sub");
}
