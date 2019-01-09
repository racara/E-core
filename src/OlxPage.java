import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;

public class OlxPage {
    WebDriver driver;

    @FindBy(
            id = "searchtext"
    )
    WebElement productName;

    @FindBy(
            id = "searchbutton"
    )
    WebElement searchButton;

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

    public OlxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setProductName(String productname) {
        this.productName.sendKeys(productname);
    }

    public void clickSearchButton() throws InterruptedException {
        this.searchButton.click();
        Thread.sleep(3000);
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

    public String getValueOfResearch1(){
        String valueSearched = driver.findElement(By.xpath("//div/ul/li[1]/a/div[2]/div[1]/h2")).getText();
        System.out.print(valueSearched);
        String priceOfProduct = driver.findElement(By.xpath("//div/ul/li[1]/a/div[3]/p")).getText();
        System.out.print(priceOfProduct);
        return valueSearched;
    }

    public String getValueOfResearch2(){
        String valueSearched = driver.findElement(By.xpath("//div/ul/li[2]/a/div[2]/div[1]/h2")).getText();
        System.out.print(valueSearched);
        String priceOfProduct = driver.findElement(By.xpath("//div/ul/li[2]/a/div[3]/p")).getText();
        System.out.print(priceOfProduct);
        return valueSearched;


    }

    public String getValueOfResearch3(){
        String valueSearched = driver.findElement(By.xpath("//div/ul/li[4]/a/div[2]/div[1]/h2")).getText();
        System.out.print(valueSearched);
        String priceOfProduct = driver.findElement(By.xpath("//div/ul/li[4]/a/div[3]/p")).getText();
        System.out.print(priceOfProduct);
        return valueSearched;

    }

    public String getValueOfResearch4(){
        String valueSearched = driver.findElement(By.xpath("//div/ul/li[5]/a/div[2]/div[1]/h2")).getText();
        System.out.print(valueSearched);
        String priceOfProduct = driver.findElement(By.xpath("//div/ul/li[5]/a/div[3]/p")).getText();
        System.out.print(priceOfProduct);
        return valueSearched;

    }

    public String getValueOfResearch5(){
        String valueSearched = driver.findElement(By.xpath("//div/ul/li[6]/a/div[2]/div[1]/h2")).getText();
        System.out.print(valueSearched);
        String priceOfProduct = driver.findElement(By.xpath("//div/ul/li[6]/a/div[3]/p")).getText();
        System.out.print(priceOfProduct);
        return valueSearched;

    }
}

