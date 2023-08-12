package com.juaracoding.utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scroll {
    private WebDriver driver;

    public Scroll(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollBy(int x, int y) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String script = String.format("window.scrollBy(%d, %d);", x, y);
        jse.executeScript(script);
    }
}
