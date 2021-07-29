import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.*;



public class SelenideTest {

    private WebSteps steps = new WebSteps();

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
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("eroshenkoam/allure-example");
            $(".header-search-input").submit();
        });

        step("Переходим в репозиторий", () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });

        step("Переходим в раздел Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        steps.checkNumber();
    }

}
