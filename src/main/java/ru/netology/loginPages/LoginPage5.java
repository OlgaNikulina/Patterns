package ru.netology.loginPages;

import org.openqa.selenium.Keys;
import ru.netology.dataGenerator.DataGenerator;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage5 {
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
        $("<span class=\"input__sub\">Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.</span>").shouldBe(visible);
    }
}
