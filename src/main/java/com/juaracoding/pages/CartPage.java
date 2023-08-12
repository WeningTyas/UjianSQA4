package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='icon_bag_alt']")
    WebElement btnChart;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    WebElement btnProceed;

    @FindBy(xpath = "//a[@class='button wc-backward']")
    WebElement btnReturnShop;

    @FindBy(xpath = "//a[@class='empty-cart']")
    WebElement btnClearCart;

    @FindBy(xpath = "//td[@class='product-thumbnail']")
    List<WebElement> listBelanja;

    public void btnChartClick() {
        btnChart.click();
    }
    public void btnProceedClick() {
        btnProceed.click();
        System.out.println("Klik Proceed Cart");
    }
    public void btnReturnShopClick() {
        btnReturnShop.click();
    }
    public void btnClearClick() {
        btnClearCart.click();
    }
    public int listOrder(){
        return listBelanja.size();
    }
}
