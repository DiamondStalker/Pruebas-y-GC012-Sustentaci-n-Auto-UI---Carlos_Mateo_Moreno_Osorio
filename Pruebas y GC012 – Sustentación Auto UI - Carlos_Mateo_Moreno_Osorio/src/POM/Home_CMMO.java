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
public class Home_CMMO {
    WebDriver driver;
    
    By btnlogin = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    public Home_CMMO(WebDriver driver) {
        this.driver = driver;
    }
    public void click_btnlogin(){
        driver.findElement(btnlogin).click();
    }
}
