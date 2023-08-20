package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Orders']")
    WebElement orders;

    @FindBy(xpath = "//span[@class='cart-name-and-total']")
    WebElement chart;

    // awalnya pakai ini karena masih kosong akunnya
    // tp skrng ga bisa, karena transaksi lamanya ga bisa dihapus
    public void menuOrderClick(){
        orders.click();
        System.out.println("Klik menu Orders");
    }
    public void btnCartClick(){
        chart.click();
        System.out.println("Klik icon Chart");
    }
}
