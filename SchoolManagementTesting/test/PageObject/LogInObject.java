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
public class LogInObject {
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"content\"]/div/div/div/div/form/div[1]/input")
    public static WebElement email;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"content\"]/div/div/div/div/form/div[2]/input")
    public static WebElement password;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"content\"]/div/div/div/div/form/div[3]/label/input")
    public static WebElement ts;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"content\"]/div/div/div/div/form/div[4]/button")
    public static WebElement login;
}
