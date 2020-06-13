/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AutomationTesting;

import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static AutomationTesting.LogIN.driver;
import PageObject.LogOutObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 *
 * @author Gayatree
 */
public class Logout {
    @Test
    public static void Logout() throws InterruptedException {
//        WebElement logout=driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[6]/a"));
        PageFactory.initElements(driver, LogOutObject.class);
        LogOutObject.logout.click();
        Reporter.log("logout success");
        //Thread.sleep(5000);
        driver.get("http://localhost/school-management-web-application/index.php?page=4");
        driver.quit();
    }    
}