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

    // Для выбора браузера при запуске из командной строки: mvn test -Dbrowser=Сhrome (mvn test -Dbrowser=Yandex)
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setup() {
        String browser = System.getProperty("browser");
        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else if (browser.equals("Yandex")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

    }

    @After
    public void clearData() {
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getLocalStorage().clear();
        ((WebStorage) webDriver).getSessionStorage().clear();
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }
}
