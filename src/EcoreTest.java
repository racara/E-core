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

    public class EcoreTest {
        private WebDriver driver;
        private String baseUrl;
        private EcorePage ecorePage;
        private String nome = "demouser";
        private String senha = "abc123";
        public EcoreTest() {
        }

        @Before
        public void setUp()  {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafa\\Desktop\\chromedriver_win32\\chromedriver.exe");
            this.driver = new ChromeDriver();
            this.baseUrl = "https://automation-sandbox.herokuapp.com";
            this.ecorePage = new EcorePage(this.driver);
            this.driver.manage().window().maximize();
            this.driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
        }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000L);
        this.driver.quit();
    }

    @Test
    public void LogarComSucesso() throws Exception {
        this.driver.get(this.baseUrl);
        this.ecorePage.setName(nome);
        this.ecorePage.setSenha(senha);
        this.ecorePage.clickLogin();
        Assert.assertEquals("Automation Example",ecorePage.getTittleMainPage());
        Assert.assertEquals("Invoice List",ecorePage.getTittleGrid());
    }

    @Test
    public void LogarSemSucesso() throws Exception {
        this.driver.get(this.baseUrl);
        this.ecorePage.setName("Rafael");
        this.ecorePage.setSenha("admddd");
        this.ecorePage.clickLogin();
        Assert.assertEquals("Wrong username or password.",ecorePage.getMessageError());

    }
    @Test
    public void ValidarDados() throws Exception {
        this.driver.get(this.baseUrl);
        this.ecorePage.setName(nome);
        this.ecorePage.setSenha(senha);
        this.ecorePage.clickLogin();
        this.ecorePage.clickLink("Rendezvous Hotel");
        Assert.assertEquals("Rendezvous Hotel",ecorePage.getHotelName());
        Assert.assertEquals("14/01/2018",ecorePage.getInvoiceDate());
        Assert.assertEquals("15/01/2018",ecorePage.getDueDate());
        Assert.assertEquals("110",ecorePage.getInvoiceNumber());
        Assert.assertEquals("0875",ecorePage.getbookingCode());
        Assert.assertEquals("JOHNY SMITH",ecorePage.getCustumerName());
        Assert.assertEquals("R2, AVENUE DU MAROC",ecorePage.getCustumerAddress());
        Assert.assertEquals("123456",ecorePage.getCustumerPostalCode());
        Assert.assertEquals("Superior Double",ecorePage.getRoom());
        Assert.assertEquals("14/01/2018",ecorePage.getcheckIn());
        Assert.assertEquals("15/01/2018",ecorePage.getcheckOut());
        Assert.assertEquals("1",ecorePage.getTotalStayCount());
        Assert.assertEquals("$150",ecorePage.getTotalStayAmount());
        Assert.assertEquals("USD $20.90",ecorePage.getDepositNow());
        Assert.assertEquals("USD $19",ecorePage.getTaxVAT());
        Assert.assertEquals("USD $209",ecorePage.getTotalAmount());
    }
}

