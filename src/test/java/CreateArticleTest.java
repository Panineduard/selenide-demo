import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.Test;
import utils.PropertyUtil;

import java.io.File;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CreateArticleTest {
    @Before
    public void setup() {
        open("https://acx-knowladge-portal-dev.ascendixonline.com");
        $(byText("Sign In")).click();
        $(byText("Sign In")).waitUntil(Condition.disappear, 20000);
        $(byText("Ascendix")).click();
        $(byAttribute("name", "loginfmt")).waitUntil(Condition.appear, 20000);
        $(byAttribute("name", "loginfmt")).setValue(PropertyUtil.getPropertyByName("user"));
        $(byAttribute("type", "submit")).click();
        $(byAttribute("name", "passwd"))
                .waitUntil(Condition.appear, 20000)
                .setValue(PropertyUtil.getPropertyByName("password"));
        $(byAttribute("type", "submit")).click();
        $(byAttribute("type", "submit")).waitUntil(Condition.appear, 20000).click();
    }

    @Test
    public void createFile() {
        $(byText("Materials")).waitUntil(Condition.appear, 20000).click();
        $(byText("Add New")).waitUntil(Condition.appear, 20000).click();
        $(byName("type")).waitUntil(Condition.enabled, 20000).selectOption("Article");
        File file = new File("src/main/resources/testFiles/TestFile.txt");
        $(byId("file-uploader")).waitUntil(Condition.exist, 20000).uploadFile(file);
        $(byName("title")).waitUntil(Condition.enabled, 20000).shouldHave(Condition.exactValue("TestFile"));
        $(byText("Confirm")).waitUntil(Condition.appear, 20000).click();
        $(byText("Confirm")).waitUntil(Condition.disappear, 20000);
        screenshot("Final View");
    }
}
