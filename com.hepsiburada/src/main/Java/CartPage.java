import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    By productNameLocator = new By.ByCssSelector("product_name_3Lh3t");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkCart() {

        return getProducts().size()  < 2;
    }

    private List<WebElement> getProducts(){

        return findAll(productNameLocator);
    }


}
