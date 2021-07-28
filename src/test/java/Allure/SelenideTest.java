package Allure;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void testRepositoryIsue(){
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("erochenkoam/allure-example");
        $(".header-search-input").submit();

        $(By.linkText("erochenkoam/allure-example")).click();
        $(By.partialLinkText("Issues")).click();
        $(By.linkText("#68")).click();
    }
}
