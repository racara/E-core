//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;

public class OlxTest {
    private WebDriver driver;
    private String baseUrl;
    private String baseUrl2;
    private OlxPage olxPage;
    private OlxStorePage olxStorePage;
    public OlxTest() {
    }

    @Before
    public void setUp()  {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafa\\Desktop\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.baseUrl = "https://sp.olx.com.br/";
        this.baseUrl2 = "https://www.olx.com.br/lojas";
        this.olxPage = new OlxPage(this.driver);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000L);
       // this.driver.quit();
    }

    @Test
    public void PesquisarLoja() throws Exception {
        this.driver.get(this.baseUrl2);
        this.olxStorePage.setStoreName("ABC");
        this.olxStorePage.clickSearchStoreButton();
        this.olxStorePage.clickPageNumberX("2");
        this.olxStorePage.clickfirstOptionsOfSecoundPage();
    }

    @Test
    public void ValidarCincoPrimeirosProdutos() throws Exception {
        this.driver.get(this.baseUrl);
        this.olxPage.setProductName("Bicicleta Preta");
        this.olxPage.clickSearchButton();
        this.olxPage.getValueOfResearch1();
        this.olxPage.getValueOfResearch2();
        this.olxPage.getValueOfResearch3();
        this.olxPage.getValueOfResearch4();
        this.olxPage.getValueOfResearch5();
    }
}
