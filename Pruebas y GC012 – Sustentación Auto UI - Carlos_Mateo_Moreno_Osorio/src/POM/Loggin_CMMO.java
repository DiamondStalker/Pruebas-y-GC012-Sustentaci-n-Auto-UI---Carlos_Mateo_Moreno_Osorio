/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author DiamondStalker
 */
public class Loggin_CMMO {
    WebDriver driver;
    By Create = By.name("SubmitCreate");
    By Email = By.id("email_create");
    By Error_MSG = By.xpath("//*[@id=\"create_account_error\"]/ol/li");
    By Sigin_in = By.id("SubmitLogin");
    
    public Loggin_CMMO(WebDriver driver) {
        this.driver = driver;
    }
    public void Click_Create(){
        driver.findElement(Create).click();
    }
    public void Click_Singin(){
        driver.findElement(Sigin_in).click();
    }
    public void setEmail(String email){
        driver.findElement(Email).sendKeys(email);
    }
    public String getError_MSG(){
        String message = driver.findElement(Error_MSG).getText();
        System.out.println("El mensaje de error es :" + message);
        return message;
    }
}
