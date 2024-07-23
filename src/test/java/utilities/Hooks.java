package utilities;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        Configuration.timeout = 15000;

    }
}
