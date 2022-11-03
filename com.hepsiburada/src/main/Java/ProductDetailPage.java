import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class ProductDetailPage extends BasePage {

    JavascriptExecutor js = (JavascriptExecutor)driver;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() throws InterruptedException {

        js.executeScript("window.scrollBy(0,200)");

        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='addToCart']"));

        addToCartButton.click();

        Thread.sleep(2000);


        WebElement closePopUp = driver.findElement(By.xpath("//a[@class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']//*[name()='svg']"));

        closePopUp.click();


        js.executeScript("window.scrollBy(200,400)");

        WebElement difShop = driver.findElement(By.xpath("//button[@class='add-to-basket button small']"));

        difShop.click();


        WebElement goCart = driver.findElement(By.xpath("//button[normalize-space()='Sepete git']"));

        goCart.click();

        Thread.sleep(2000);

    }

}
