package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.*;
import com.juaracoding.utils.Scroll;
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

        loginTest(driver);

        addToChartTest(driver);

        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    public static void loginTest(WebDriver driver){
        Scroll scroll = new Scroll(driver);
        scroll.scrollBy(0, 200);
        System.out.println("Scroll ke bawah, utk munculkan header");

        DashboardPage dashboard = new DashboardPage();
        dashboard.menuClick("Login");
        System.out.println("Klik menu My Account");

        scroll.scrollBy(0, 500);

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        System.out.println("Test Login");

        scroll.scrollBy(0, 500);
        loginPage.verifikasi();
    }

    public static void addToChartTest(WebDriver driver){
        Scroll scroll = new Scroll(driver);

        AccountPage akun = new AccountPage();
        akun.orderClick();

        scroll.scrollBy(0, 500);

        OrderPage order = new OrderPage();
        order.browseProductClick();

        scroll.scrollBy(0, 500);

        ShopPage shop = new ShopPage();
        shop.selectProduct(); // ini pakai list?

        scroll.scrollBy(0, 500);

        ProductPage produk = new ProductPage();
        produk.selectColor();
        produk.selectSize();
        produk.addToChart();
        System.out.println("Test Add Product");

        produk.verifikasi();
    }
}
