package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    WebElement btnLogin;

    public void login(){
        username.sendKeys("weningputri3@gmail.com");
        password.sendKeys("GunakanSandiKuat");
        btnLogin.click();
        System.out.println("Masukkan Username & Password");
    }
    public void verifikasi(){
        String menu = driver.findElement(By.xpath("//a[normalize-space()='Dashboard']")).getText();
        if(menu.contains("Dashboard")){
            System.out.println("Login Oke!");
        } else {
            System.out.println("Login Failed");
        }
    }
}
