import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class CaseWithoutLogin extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test(priority = 1) // Kullanıcı ürün için arama yapar

    public void search_product(){

        homePage = new HomePage(driver);
        homePage.searchBox().search("Laptop");
        productsPage = new ProductsPage(driver);

        assertTrue(productsPage.isOnProductsPage() ,
                "Not on products page!");

    }


    @Test(priority = 2)   // Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.

    public void select_a_product() throws InterruptedException {

        productsPage.selectProduct();
        productDetailPage =new ProductDetailPage(driver);

    }

    @Test(priority = 3)   //Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.

    public void add_product_to_cart() throws InterruptedException {

        productDetailPage =new ProductDetailPage(driver);
        productDetailPage.addToCart();
        cartPage = new CartPage(driver);
        Thread.sleep(1000);

    }

    @Test(priority = 4)   //Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.
    public void go_to_cart() throws InterruptedException {

        cartPage = new CartPage(driver);
        cartPage.checkCart();

    }

}

