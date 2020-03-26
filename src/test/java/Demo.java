import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.Test;
import utils.PropertyUtil;

import java.io.File;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Demo {
    @Before
    public void setup() {

    }

    @Test
    public void createItem() {
        open("https://acx-knowladge-portal-dev.ascendixonline.com/");
        $(byText("Sign In")).click();
        $(byText("Sign In")).waitUntil(Condition.disappear, 20000);
        $(byText("Ascendix")).click();
        $(byName("loginfmt")).waitUntil(Condition.appear, 20000).setValue(PropertyUtil.getPropertyByName("user"));
        $(byAttribute("type", "submit")).click();
        $(byName("passwd")).waitUntil(Condition.appear, 20000).setValue(PropertyUtil.getPropertyByName("password"));
        $(byAttribute("type", "submit")).click();
        $(byAttribute("type", "submit")).waitUntil(Condition.appear, 2000).click();
        $(byText("Materials")).waitUntil(Condition.appear, 2000).click();
        $(byText("Add New")).waitUntil(Condition.appear, 2000).click();
        $(byName("type")).waitUntil(Condition.enabled, 20000).selectOption("Article");
        File file = new File("src/resources/test-files/Demo.txt");
        $(byId("file-uploader")).waitUntil(Condition.exist, 20000).uploadFile(file);
        $(byName("title")).waitUntil(Condition.enabled, 20000).shouldHave(Condition.exactValue("Demo"));
        $(byText("Confirm")).waitUntil(Condition.appear, 2000).click();
        screenshot("Final Vew");
    }
}
