/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author Gayatree
 */
public class LogOutObject {
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[6]/a")
    public static WebElement logout;
}
