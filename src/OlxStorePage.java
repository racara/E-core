import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;

public class OlxStorePage {
    WebDriver driver;


    @FindBy(
            id = "store_query"
    )
    WebElement storeName;

    @FindBy(
            xpath = "//*[@id=\"store_listing_search\"]/button"
    )
    WebElement searchStoreBtn;

    @FindBy(
            xpath = "//*[@id=\"ct\"]/div/div[3]/ul/li[1]/div/a/div[2]/h3"
    )
    WebElement firstOptionOfSecoundPage;

    public OlxStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void setStoreName(String storeName) {
        this.storeName.sendKeys(storeName);
    }

    public void clickSearchStoreButton() throws InterruptedException {
        this.searchStoreBtn.click();
        Thread.sleep(3000);
    }


    public void clickPageNumberX(String pageNumber) throws InterruptedException {

        List<WebElement> allPages = driver.findElements(By.xpath("//*[@id=\"ct\"]/div/div[4]/ul/li"));
        List<String> weText = new ArrayList<>();
        for(WebElement webElement: allPages){
            weText.add(webElement.getText());
        }
        int index = weText.indexOf(pageNumber);
        index++;
        WebElement link = driver.findElement(By.xpath("//*[@id=\"ct\"]/div/div[4]/ul/li[" + index + "]/a"));
        link.click();
        Thread.sleep(3000);

    }

    public void clickfirstOptionsOfSecoundPage() throws InterruptedException {
        this.firstOptionOfSecoundPage.click();
        Thread.sleep(3000);

    }

}

