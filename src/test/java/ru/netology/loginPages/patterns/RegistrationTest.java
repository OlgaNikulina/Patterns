package ru.netology.loginPages.patterns;
import com.github.javafaker.Faker;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.loginPages.LoginPage;
import ru.netology.loginPages.LoginPage2;
import ru.netology.loginPages.dataGenerator.DataGenerator;
import java.util.Locale;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {
    DataGenerator.Registration registration = new DataGenerator.Registration("", "", "", "");
    private Faker faker;

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
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
}
