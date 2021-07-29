package withAllure;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTestWithAllure {

    @BeforeAll
    static void setup() {
        baseUrl = "https://github.com";
        startMaximized = true;
    }

    @Test
    public void testRepositoryIssue() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий", () -> {
            $(".header-search-input").setValue("eroshenkoam/allure-example").submit();
        });

        step("Переходим в репозиторий", () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });

        step("Переходим в раздел Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем, что существует Issue с номером 68", ()->{
            $(withText("#68")).should(exist);
        });

    }
}
