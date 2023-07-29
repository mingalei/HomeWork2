import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class HomeWork2
{
    @BeforeAll
    static void beforeAll()
    {
        open("https://github.com/");
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy="eager";

    }
    @Test
    void homeWork2()
    {
        $("span[class='flex-1']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $$("[data-testid='results-list']").first().$("a").click();
        $("[href='/selenide/selenide/wiki']").click();
        $x("//*[contains(text(), 'Soft assertions')]").click();
        $("div[class='markdown-body']").shouldHave(text("Using JUnit5 extend test class:\n" +
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
