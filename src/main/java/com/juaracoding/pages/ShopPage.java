package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopPage {
    private WebDriver driver;

    public ShopPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "noo-product-inner")
    WebElement clickProduct;

    public void selectProduct(){
        int index = 2; //produk ke 3 di list produk
        List<WebElement> listProduct = driver.findElements(By.xpath("//div[@class='noo-product-inner']"));
        WebElement produk = listProduct.get(index);
        produk.click();
        System.out.println("Pilih pruduk");
    }

}
