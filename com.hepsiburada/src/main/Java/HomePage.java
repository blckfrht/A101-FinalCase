import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage{

    SearchBox searchBox;

    public HomePage(WebDriver driver) {

        super(driver);
        searchBox = new SearchBox(driver);

    }

    public SearchBox searchBox() {
        return(searchBox);
    }

    public void login() throws InterruptedException {

        WebElement loginMain =  driver.findElement(By.xpath("//span[@title='Giriş Yap']"));
        WebElement loginSub =  driver.findElement(By.xpath("//a[@id='login']"));

        new Actions(driver)
                .moveToElement(loginMain)
                .perform();

       loginSub.click();

    }


}
