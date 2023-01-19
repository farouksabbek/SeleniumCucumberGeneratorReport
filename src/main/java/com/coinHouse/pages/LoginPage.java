package com.coinHouse.pages;

import com.coinHouse.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginPage extends Base {

    public LoginPage(){
        try {
            File file = new File("src/main/java/com/coinHouse/properties/config.properities");
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FindBy(id ="customer_email")
    WebElement emailField;

    @FindBy(id ="customer_password")
    WebElement passwordField;

    @FindBy(id = "email-login")
    WebElement loginButton;

    @FindBy(id="v2_customers_two_factor_verify_otp_form_otp")
    WebElement verifCodeFiled;

    @FindBy(id="verify-otp")
    WebElement verifButton;


    public void connectToTheApp(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void connectToTheAppWithProp(){
        emailField.sendKeys(prop.getProperty("userName"));
        passwordField.sendKeys(prop.getProperty("password"));
        loginButton.click();
    }

    public void verifyAccount (){
        verifCodeFiled.sendKeys("000000");
        verifButton.click();
    }

}
