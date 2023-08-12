package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    WebElement btnLogin;

    @FindBy(xpath = "//a[normalize-space()='Dashboard']")
    WebElement menu;

    public void login(String uname, String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        btnLogin.click();
        System.out.println("Masukkan Username & Password");
    }

    public void verifikasi(){
        String actual = menu.getText();
        String expect = "Dashboard";
        if(actual.contains(expect)){
            System.out.println("Login Oke!");
        } else {
            System.out.println("Login Failed");
        }
    }

}


/*
* Expect (Harapkan) & Actual (Aktual/hasil)
*
* uname : "weningputri3@gmail.com"
* pwd   : "GunakanSandiKuat"
* */