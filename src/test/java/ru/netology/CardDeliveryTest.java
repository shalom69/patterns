package ru.netology.web;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.web.DataGenerator.Registration.generateDate;
import static ru.netology.web.DataGenerator.Registration.generateUser;

public class CardDeliveryTest {

    @BeforeEach
    void SetUp() {
        open("http://localhost:9999");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
    }

    @Test
    void shouldSendFormValid() {
        User user = generateUser();
        $("[data-test-id=city] input").setValue(user.getCity());
        $(".calendar-input input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $(".calendar-input input").setValue(generateDate(8));
        $("[data-test-id=name] input").setValue(user.getName());
        $("[data-test-id=phone] input").setValue(user.getPhone());
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(withText("Успешно!")).shouldBe(Condition.visible, Duration.ofSeconds(15000));
        $("[data-test-id=success-notification]")
                .shouldHave(exactText("Успешно! Встреча успешно запланирована на " + generateDate(8)));
        $(".calendar-input input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $(".calendar-input input").setValue(generateDate(9));
        $(".button").click();
        $(withText("Необходимо подтверждение")).shouldBe(Condition.visible, Duration.ofSeconds(15000));
        $(".button__text").click();
        $("[data-test-id=success-notification]").shouldBe(Condition.visible, Duration.ofSeconds(15000)).shouldHave(exactText("Успешно! Встреча успешно запланирована на " + generateDate(9)));
    }

}
