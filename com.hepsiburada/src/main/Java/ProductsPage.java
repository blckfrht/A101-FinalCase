import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class ProductsPage extends BasePage{

    By searchResultsLocator = By.xpath("//div[@class='searchResultSummaryBar-CbyZhv5896ASVcYBLKmx']");

    JavascriptExecutor js = (JavascriptExecutor)driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductsPage() {
        return isDisplayed(searchResultsLocator);
    }

    public void selectProduct() throws InterruptedException {

        js.executeScript("window.scrollBy(0,500)");

        WebElement firstProduct = driver.findElement(By.xpath("//*[@id='i0']"));

        firstProduct.click();

        Thread.sleep(3000);


        String parent=driver.getWindowHandle();

        Set<String> s=driver.getWindowHandles();

        Iterator<String> I1= s.iterator();

        while(I1.hasNext()) {

            String child_window=I1.next();

            if(!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }

        }

    }

}
