import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainTest {
    @Before
    public void setUp() {

    }

    @Test
    public void fillItemForm() {
        open("https://acx-knowladge-portal-dev.ascendixonline.com");
        $(byText("Materials")).click();
        $(byText("Add New")).click();

        File file = new File("src/resources/img/test-file.png");
        $("#file-uploader").uploadFile(file);
    }
}
