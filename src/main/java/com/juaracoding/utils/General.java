package com.juaracoding.utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class General {
    private WebDriver driver;

    public General(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollBy(int x, int y) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String script = String.format("window.scrollBy(%d, %d);", x, y);
        jse.executeScript(script);
    }
    public static void delay(long sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    public static void maximize(WebDriver driver){
        driver.manage().window().maximize();
    }
    public static void refresh(WebDriver driver){
        driver.navigate().refresh();
    }
    public static void back(WebDriver driver){
        driver.navigate().back();
    }
}


/*
* Utils:
* Package ini dapat digunakan untuk menyimpan utilitas atau fungsi-fungsi yang dapat digunakan
* di seluruh proyek, seperti inisialisasi WebDriver, fungsi-fungsi bantuan, atau pengaturan umum lainnya.
* */