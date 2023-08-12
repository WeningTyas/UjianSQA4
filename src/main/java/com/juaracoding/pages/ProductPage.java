package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement selectColor;

    @FindBy(xpath = "//select[@id='pa_size']")
    WebElement selectSize;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToChart;

    @FindBy(xpath = "//div[@role='alert']")
    WebElement pesan;

    public void selectColor(){
        selectColor.click();
        selectColor.sendKeys(Keys.ARROW_DOWN);
        selectColor.sendKeys(Keys.ENTER);
        System.out.println("Pilih warna");
    }
    public void selectSize(){
        selectSize.click();
        selectSize.sendKeys(Keys.ARROW_DOWN);
        selectSize.sendKeys(Keys.ENTER);
        System.out.println("Pilih ukuran");
    }
    public void addToChart(){
        addToChart.click();
        System.out.println("Klik Add to Cart");
    }
    public void verifikasi(){
        String actual = pesan.getText();
        String expect = "has been added to your cart";
        if(actual.contains(expect)){
            System.out.println("Tambah produk Oke!");
        } else {
            System.out.println("Tambah produk gagal");
        }
    }
}
