import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleTest {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SimpleTest.class);

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднялся");
    }
    @Test
    public void openPage() {
        driver.get("https://otus.ru/");
        logger.info("Страница открылась");
    }

    @AfterTest
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер всё");
        }
    }
}