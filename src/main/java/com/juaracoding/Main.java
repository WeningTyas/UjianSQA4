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

        //Tambah produk
        addProduct(driver, 2);
        back(driver);
        back(driver);
        addProduct(driver, 4);

        //

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
        akun.orderClick();

        general.scrollBy(0, 500);

        OrderPage order = new OrderPage();
        order.browseProductClick();

        general.scrollBy(0, 500);
    }

    public static void addProduct(WebDriver driver, int index){
        General general = new General(driver);
        ShopPage shop = new ShopPage();

        shop.selectProduct(index);

        try{
            general.scrollBy(0, 500);
        } finally {
            general.scrollBy(0, 100);
        }

        ProductPage produk = new ProductPage();
        produk.selectColor();
        produk.selectSize();
        produk.addToChart();
        produk.verifikasi();
    }

    static void back(WebDriver driver){
        driver.navigate().back();
    }
    static void refresh(WebDriver driver){
        driver.navigate().refresh();
    }

}
