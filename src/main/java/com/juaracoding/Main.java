package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.*;
import com.juaracoding.utils.General;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();

        driver.get("https://shop.demoqa.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Buka Browser dan buka URL");

        //Login
        loginTest(driver);

        addToChartTest(driver);

        //Tambah produk, panggil pakai indexnya
        addProduct(driver, 2);
        General.back(driver);
        General.back(driver);
        addProduct(driver, 3);

        //

        //Checkout
        checkoutTest(driver);

        General.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    public static void loginTest(WebDriver driver){
        General general = new General(driver);
        general.scrollBy(0, 200);
        System.out.println("Scroll ke bawah, utk munculkan header");

        DashboardPage dashboard = new DashboardPage();
        dashboard.menuClick("Login");
        System.out.println("Klik menu My Account");

        general.scrollBy(0, 500);

        LoginPage loginPage = new LoginPage();
        loginPage.login("weningputri3@gmail.com", "GunakanSandiKuat");
        System.out.println("Test Login");

        general.scrollBy(0, 500);
        loginPage.verifikasi();
    }

    public static void addToChartTest(WebDriver driver){
        General general = new General(driver);
        AccountPage akun = new AccountPage();
        CartPage shop = new CartPage();

        general.scrollBy(0, -500);
        akun.btnCartClick();
        general.scrollBy(0, 500);

        //cek keranjangnya, masih ada gak, klo ada, dihapus aja dulu
        if (shop.listOrder() == 0) {
            shop.btnReturnShopClick();
            System.out.println("keranjang kosong");
        } else {
            shop.btnClearClick();
            general.scrollBy(0, 500);
            shop.btnReturnShopClick();
            System.out.println("keranjang masih ada isi nih");
        }
    }

    public static void addProduct(WebDriver driver, int index){
        General general = new General(driver);
        ShopPage shop = new ShopPage();

        shop.selectProduct(index);

        //karena kadang ada produk yg perlu di scroll 2x ada yg 1x udh bisa
        try{
            general.scrollBy(0, 600);
        } finally {
            general.scrollBy(0, 100);
        }

        ProductPage produk = new ProductPage();
        produk.selectColor();
        produk.selectSize();
        produk.addToChart();
        general.scrollBy(0, 100);
        produk.verifikasi();
    }
    public static void checkoutTest(WebDriver driver){
        General general = new General(driver);
        CartPage cart = new CartPage();
        CheckoutPage checkout = new CheckoutPage();

        cart.btnChartClick();
        try{
            general.scrollBy(0, 800);
        } finally {
            general.scrollBy(0, 100);
        }
        cart.btnProceedClick();

        checkout.billingDetail("Wening", "Tyas", "Indonesia",
                 "Perum. Interkon", "Blok GB 2 No 11", "Jakarta Barat",
                "DKI Jakarta", "11640", "081233213411");
        checkout.btnOrderClick();
        general.scrollBy(0, 100);
        checkout.verifikasi();
    }

}
