import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void sendData() {

       WebElement loginWithFb = driver.findElement(By.xpath("//button[@id='btnFacebook']//div[2]"));

       loginWithFb.click();


       WebElement emailBox =  driver.findElement(By.xpath("//input[@id='email']"));

       emailBox.sendKeys("ferhatcelebitestautomation@gmail.com");



       WebElement passwordBox = driver.findElement(By.xpath("//input[@id='pass']"));

       passwordBox.sendKeys("Test.123456");

       WebElement loginBtn = driver.findElement(By.xpath("//button[@id='loginbutton']"));

       loginBtn.submit();

    }
}
