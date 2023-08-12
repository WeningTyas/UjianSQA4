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

    @FindBy(xpath = "//div[@class='noo-product-inner']")
    List<WebElement> listProduct;

    public void selectProduct(int produk){
        WebElement product = listProduct.get(produk);
        product.click();
        System.out.println("Pilih produk ke " + produk);
    }

}
