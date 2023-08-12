package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='My Account']")
    WebElement btnMenuLogin;

    @FindBy(xpath = "//a[normalize-space()='Checkout']")
    WebElement btnMenuCheckout;

    public void menuClick(String menu){
        if (menu == "Login"){
            btnMenuLogin.click();
        } else if (menu == "Checkout"){
            btnMenuCheckout.click();
        } else {
            driver.navigate().refresh();
        }
    }


}
