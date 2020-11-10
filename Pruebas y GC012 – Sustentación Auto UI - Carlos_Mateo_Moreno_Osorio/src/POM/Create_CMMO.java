/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author DiamondStalker
 */
public class Create_CMMO {
        WebDriver driver;
        By FNameC = By.id("customer_firstname");
        By LNameC = By.id("customer_lastname");
        By Passw = By.id("passwd");
        By Fname = By.id("firstname");
        By Lname = By.id("lastname");
        By Address = By.id("address1");
        By city = By.id("city");
        By state = By.id("id_state");
        By postcode = By.id("postcode");
        By country = By.id("id_country");
        By phone_mobile = By.id("phone_mobile");
        By BtnsubmitAccount = By.id("submitAccount");
        By msg = By.xpath("//*[@id=\"center_column\"]/div/ol/li[1]");
        
        
    public Create_CMMO(WebDriver driver) {
        this.driver = driver;
    }
    
    public void setFnameC(String fname){
        driver.findElement(FNameC).sendKeys(fname);
    }
    public void setLNameC(String fname){
        driver.findElement(LNameC).sendKeys(fname);
    }
    public void setPassw(String fname){
        driver.findElement(Passw).sendKeys(fname);
    }
    public void setFname(String fname){
        driver.findElement(Fname).sendKeys(fname);
    }
    public void setLname(String fname){
        driver.findElement(Lname).sendKeys(fname);
    }
    public void setAddress(String address){
        driver.findElement(Address).sendKeys(address);
    }
    public void setACity(String address){
        driver.findElement(city).sendKeys(address);
    }
    public void setphone_mobile(String address){
        driver.findElement(phone_mobile).sendKeys(address);
    }
    public void setselectstate(int numero){
        WebElement cmb_marital = driver.findElement(state);
        Select nation = new Select(cmb_marital);
        nation.selectByIndex(numero);
    }
    public void clickBtnsubmitAccount(){
        driver.findElement(BtnsubmitAccount).click();
    }
     public void setCountry(){
        WebElement cmb_marital = driver.findElement(country);
        Select marital = new Select(cmb_marital);
         marital.selectByVisibleText("United States");
    }
     public String getError_MSG(){
        String message = driver.findElement(msg).getText();
        System.out.println("El mensaje de error es :" + message);
        return message;
    }
}
