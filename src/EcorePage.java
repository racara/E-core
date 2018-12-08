import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class EcorePage {
    WebDriver driver;

    @FindBy(
            name = "username"
    )
    WebElement user;

    @FindBy(
            name = "password"
    )
    WebElement senha;

    @FindBy(
            id = "btnLogin"
    )
    WebElement btLogin;

    @FindBy(
            xpath = "/html/body/section/div/div[2]/div[5]/a"
    )
    WebElement firstOptClick;


    public EcorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setName(String candidatename) {
        this.user.sendKeys(candidatename);
    }

    public void setSenha(String senha) {
        this.senha.sendKeys(senha);
    }

    public void clickLogin() throws InterruptedException {
        this.btLogin.click();
        Thread.sleep(10000L);
    }

    public void clickFirstOpt() throws InterruptedException {
        this.firstOptClick.click();
    }

    public void clickLink(String hotelName) throws InterruptedException {

        List<WebElement> allHotelNames = driver.findElements(By.xpath("/html/body/section/div/div/div[2]"));
        List<String> weText = new ArrayList<>();
        for(WebElement webElement: allHotelNames){
            weText.add(webElement.getText());
        }
        int index = weText.indexOf(hotelName);
        index++;
        WebElement link = driver.findElement(By.xpath("/html/body/section/div/div[" + index + "]/div[5]/a"));
        link.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(10000);
    }

    public String getHotelName(){
        String hotelName = driver.findElement(By.xpath("//h4")).getText();
        return hotelName;
    }

    public String getInvoiceDate(){
        String invoiceData = driver.findElement(By.xpath("//div/ul/li[1]")).getText();
        String justInvoiceDate = invoiceData.replace("Invoice Date: ", "");
        return justInvoiceDate;
    }
    public String getDueDate(){
         String dueDate = driver.findElement(By.xpath("//div/ul/li[2]")).getText();
         String justDueDate = dueDate.replace("Due Date: ", "");
        return justDueDate;
    }
    public String getInvoiceNumber(){
        String invoiceNumber = driver.findElement(By.xpath("//h6")).getText();
        String justInvoiceNumber = invoiceNumber.replace("Invoice #", "");
        String officialInvoiceNumber = justInvoiceNumber.replace(" details","");
        return officialInvoiceNumber;
    }
    public String getbookingCode(){
        String bookingCode = driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td[2]")).getText();
        return bookingCode;
    }
    public String getCustumerName(){
        String[] cstomerDetails = driver.findElement(By.xpath("//html/body/section/div/div")).getText().split("\n");
        String nome = cstomerDetails[0];
        return nome;
    }
    public String getCustumerAddress(){
        String[] cstomerDetails = driver.findElement(By.xpath("//html/body/section/div/div")).getText().split("\n");
        String address = cstomerDetails[1];
        return address;
    }
    public String getCustumerPostalCode(){
        String[] cstomerDetails = driver.findElement(By.xpath("//html/body/section/div/div")).getText().split("\n");
        String cep = cstomerDetails[2];
        return cep;
    }
    public String getRoom(){
        String room = driver.findElement(By.xpath("//table[1]/tbody/tr[2]/td[2]")).getText();
        return room;
    }
    public String getcheckIn(){
        String checkIn = driver.findElement(By.xpath("//table[1]/tbody/tr[5]/td[2]")).getText();
        return checkIn;
    }
    public String getcheckOut(){
        String checkOut = driver.findElement(By.xpath("//table[1]/tbody/tr[6]/td[2]")).getText();
        return checkOut;
    }

    public String getTotalStayCount(){
        String totalStayCount = driver.findElement(By.xpath("//table[1]/tbody/tr[3]/td[2]")).getText();
        return totalStayCount;
    }

    public String getTotalStayAmount(){
        String totalStayAmount = driver.findElement(By.xpath("//table[1]/tbody/tr[4]/td[2]")).getText();
        return totalStayAmount;
    }

    public String getDepositNow(){
        String depositNow = driver.findElement(By.xpath("//table[2]/tbody/tr/td[1]")).getText();
        return depositNow;
    }

    public String getTaxVAT(){
        String taxVAT = driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]")).getText();
        return taxVAT;
    }

    public String getTotalAmount(){
        String totalAmount  = driver.findElement(By.xpath("//table[2]/tbody/tr/td[3]")).getText();
        return totalAmount;
    }

    public String getTittleMainPage(){
        String tittleMainPage = driver.findElement(By.xpath("/html/body/nav/span")).getText();
        return tittleMainPage;
    }

    public String getTittleGrid(){
        String tittleGrid = driver.findElement(By.xpath("/html/body/section/div/header/div/div/h2")).getText();
        return tittleGrid;
    }

    public String getMessageError(){
        String errorMensagem = driver.findElement(By.xpath("/html/body/div/div[1]")).getText();
        return errorMensagem;
    }

}


