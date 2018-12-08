package actionClass;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {
    private WebDriver driver;
    String baseUrl;
    private JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafael\\workspace\\SeleniumAutomation\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://jqueryui.com/slider/";
        js = (JavascriptExecutor) driver;

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
    }



    @Test
    public void test() throws InterruptedException {
        driver.get(baseUrl);
        driver.switchTo().frame(0);
        Thread.sleep(3000);

        // Using the actions class
        WebElement element = driver.findElement(By.xpath("//div[@id='slider']/span"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(element, 300, 0).perform();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
