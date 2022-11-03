import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CaseWithLogin extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;

    LoginPage loginPage;

    CartPage cartPage;


    //Kullanıcı Hepsiburada.com sitesini ziyaret eder.
    // Kullanıcı giriş işlemiyapılır.
    // Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır.
    @Test(priority = 1)
    public void loginAccount () throws InterruptedException {

        homePage =new HomePage(driver);
        homePage.login();

        loginPage = new LoginPage(driver);
        loginPage.sendData();
        Thread.sleep(2000);


    }

    //Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
    @Test(priority = 2)
    public void search_product(){

        homePage = new HomePage(driver);
        homePage.searchBox().search("Laptop");
        productsPage = new ProductsPage(driver);

        assertTrue(productsPage.isOnProductsPage() ,
                "Not on products page!");

    }

    // Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir)
    // ürün seçer.
    @Test(priority = 3)
    public void select_a_product() throws InterruptedException {

        productsPage.selectProduct();
        productDetailPage =new ProductDetailPage(driver);

    }

    //Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
    @Test(priority = 4)
    public void add_product_to_cart() throws InterruptedException {

        productDetailPage =new ProductDetailPage(driver);
        productDetailPage.addToCart();
        cartPage = new CartPage(driver);
        Thread.sleep(1000);

    }

    //Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.
    @Test(priority = 5)
    public void go_to_cart(){

        cartPage = new CartPage(driver);
        cartPage.checkCart();

    }

}


