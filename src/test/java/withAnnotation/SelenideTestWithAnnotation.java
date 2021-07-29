package withAnnotation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;

public class SelenideTestWithAnnotation {

    private WebSteps steps = new WebSteps();

    @BeforeAll
    static void setup() {
        baseUrl = "https://github.com";
        startMaximized = true;
    }

    @Test
    public void testRepositoryIssue() {
        steps.openHub()
             .researchRepo()
             .openRepo()
             .changePage()
             .checkNumber();
    }
}
