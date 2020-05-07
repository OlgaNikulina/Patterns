package ru.netology.loginPages;

import ru.netology.loginPages.dataGenerator.DataGenerator;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;
import org.openqa.selenium.Keys;

import java.time.LocalDate;


public class LoginPage {

    public void validLogin(DataGenerator.Registration registration) {
        $("[placeholder='Город']").setValue(registration.getLocation());
        $("span.menu-item__control").click();
        $("[placeholder='Дата встречи']").sendKeys(Keys.CONTROL + "a");
        $("[placeholder='Дата встречи']").sendKeys(Keys.DELETE);
        $("[placeholder='Дата встречи']").setValue(String.valueOf(LocalDate.now().plusDays(3)));
        $("[name='name']").setValue(registration.getName());
        $("[name='phone']").setValue(registration.getPhone());
        $("span[class='checkbox__text']").click();
        $$("button").find(exactText("Забронировать")).click();
        $("div.notification__title").shouldBe(visible);
    }
}
