package ru.praktikum.diplom_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import java.util.concurrent.TimeUnit;

public class AbstractUITest {
    protected static WebDriver webDriver;
    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        WebDriverManager.chromedriver().setup(); // TODO разкомментировать строчку и тесты запустятся в Google Chrome или закомментировать строчку чтобы тесты прошли Яндекс.Браузере
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void clearData(){
        webDriver.manage().deleteAllCookies();
        ((WebStorage)webDriver).getLocalStorage().clear();
        ((WebStorage)webDriver).getSessionStorage().clear();
    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
    }
}
