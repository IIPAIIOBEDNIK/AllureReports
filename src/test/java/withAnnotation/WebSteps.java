package withAnnotation;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public WebSteps openHub(){
        open("https://github.com");
        return this;
    }

    @Step("Ищем репозиторий")
    public WebSteps researchRepo(){
        $(".header-search-input").setValue("eroshenkoam/allure-example").submit();
        return this;
    }

    @Step("Переходим в репозиторий")
    public WebSteps openRepo(){
        $(linkText("eroshenkoam/allure-example")).click();
        return this;
    }

    @Step("Переходим в раздел Issues")
    public WebSteps changePage(){
        $(partialLinkText("Issues")).click();
        return this;
    }

    @Step("Проверяем, что существует Issue с номером 68")
    public void checkNumber(){
        $(withText("#68")).should(exist);
    }
}
