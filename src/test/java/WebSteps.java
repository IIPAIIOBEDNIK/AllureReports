import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class WebSteps {

    @Step("Проверяем, что существует Issue с номером 68")
    public void checkNumber(){
        $(withText("#68")).should(exist);
    }
}
