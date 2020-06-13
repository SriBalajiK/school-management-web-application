/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PageObject;

import static org.openqa.selenium.By.xpath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 *
 * @author Gayatree
 */
public class MarkViewObject {
    @FindBy(how = How.CLASS_NAME, className = "dropdown-toggle")
    public static WebElement marks;
    @FindBy(how = How.XPATH, xpath = "//ul//ul//li[2]//a")
    public static WebElement markview;
    @FindBy(how = How.XPATH, xpath = "//select//option[@value='Eleven']")
    public static WebElement classsection1;
    @FindBy(how = How.XPATH, xpath ="//select//option[@value='Science']")
    public static WebElement department1;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"nav-after\"]/div/div/div/form/button")
    public static WebElement view;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"table_in\"]/tbody/tr[1]/td[9]/input")
    public static WebElement commentupdate;        
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"content\"]/div/div/div/div[2]/div/button")
    public static WebElement updatedata;
}
