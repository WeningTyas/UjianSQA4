package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.General;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //Biling Detail
    @FindBy(xpath = "//input[@id='billing_first_name']")
    WebElement txtFirstName;
    @FindBy(xpath = "//input[@id='billing_last_name']")
    WebElement txtLastName;
    @FindBy(xpath = "//option[text()='Indonesia']")
    WebElement listCountry;
    @FindBy(xpath = "//input[@id='billing_address_1']")
    WebElement txtAddress;
    @FindBy(xpath = "//input[@id='billing_address_2']")
    WebElement txtDetailAddress;

    @FindBy(xpath = "//input[@id='billing_city']")
    WebElement txtCity;
    @FindBy(xpath = "//option[text()='DKI Jakarta']")
    WebElement listProvince;
    @FindBy(xpath = "//input[@id='billing_postcode']")
    WebElement txtPostZip;
    @FindBy(xpath = "//input[@id='billing_phone']")
    WebElement txtPhone;

    @FindBy(xpath = "//input[@id='terms']")
    WebElement checkAgreement;
    @FindBy(xpath = "//button[@id='place_order']")
    WebElement btnOrder;

    @FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
    WebElement pesan;
    @FindBy(xpath = "//li[contains(text(),'Please read and accept the terms and conditions to')]")
    WebElement alert;


    public void billingDetail(String firstName, String lastName, String country,
                              String address, String detail, String city,
                              String province, String posZip, String phone){
        clear();
        General scroll = new General(driver);
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        //listCountry.sendKeys(country);
        listCountry.click();
        txtAddress.sendKeys(address);
        txtDetailAddress.sendKeys(detail);

        scroll.scrollBy(0, 500);

        txtCity.sendKeys(city);
        //listProvince.sendKeys(province);
        listProvince.click();
        txtPostZip.sendKeys(posZip);
        txtPhone.sendKeys(phone);

        //Jangan lupa chekboxnya
        if (!checkAgreement.isSelected()) {
            checkAgreement.click();
        }
        System.out.println("Detail Billing ditambahkan");
    }
    public void btnOrderClick(){
        btnOrder.click();
        System.out.println("Klik Checkout!");
    }
    public void verifikasi(){
        String actual = pesan.getText();
        String expect = "Thank you. Your order has been received.";

        if(actual.contains(expect)){
            System.out.println("Berhasil di checkout");
        } else {
            System.out.println("Gagal checkout");
        }
    }

    public void clear(){
        // bersihin teks inputnya dulu, nnti klo gak bisa dobel2
        txtFirstName.clear();
        txtLastName.clear();
        txtAddress.clear();
        txtDetailAddress.clear();
        txtCity.clear();
        txtPostZip.clear();
        txtPhone.clear();
    }

    public void negative(){
        String actual = alert.getText();
        String expect = "Please read and accept the terms and conditions";

        if(actual.contains(expect)){
            System.out.println("Peringatan muncul");
        } else {
            System.out.println("Peringatan gagal");
        }

    }
}
