package ru.netology.service;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallbackSelenideTest {

        @BeforeEach
        void setUp() {
            open("http://localhost:9999");
        }


        @Test
        void shouldTestRequest() {
            //open("http://localhost:9999");
           SelenideElement form = $("form");
            form.$("[data-test-id=name] input").setValue("Иванович Сергей");
            form.$("[data-test-id=phone] input").setValue("+88008888888");
            form.$("[data-test-id=agreement]").click();
            form.$("[class=button__text]").click();
            $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
        }
    }
