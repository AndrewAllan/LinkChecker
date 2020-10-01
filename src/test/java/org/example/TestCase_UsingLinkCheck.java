package org.example;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestCase_UsingLinkCheck {
    WebDriver driver;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/WebDrivers/chromedriver.exe");
        driver = new ChromeDriver();
      //  driver.get("https://england.shelter.org.uk/support_us/events/faqs");
        driver.get("https://www.google.com/");
        driver.manage().window().fullscreen();
    }

    @Test
    public void test() {
        ///the below method shows how the linkChecker class can be used it returns a list of list of String

        LinkChecker lkcheck = new LinkChecker();
        List<List<String>> listOfLists = lkcheck.checker(driver);
        for (int i = 0; i <= listOfLists.size() - 1; i++) {
            System.out.println("url = " + listOfLists.get(i).get(0));
            System.out.println("responce code = " + listOfLists.get(i).get(1));

        }
    }
}
