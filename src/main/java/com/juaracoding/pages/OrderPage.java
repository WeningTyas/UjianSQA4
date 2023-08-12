package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='woocommerce-Button button']")
    WebElement browseProduct;

    public void browseProductClick(){
        browseProduct.click();
        System.out.println("Browse Product");
    }
    /*
    * Udah ga lewat sini lagi, karena transaksi lamanya ga bisa dihapus
    * */
}
