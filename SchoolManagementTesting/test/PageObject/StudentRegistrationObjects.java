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
public class StudentRegistrationObjects {
    @FindBy(how = How.ID, id = "stc_1")
    public static WebElement education;
    @FindBy(how = How.ID, id = "roll")
    public static WebElement id;
    @FindBy(how = How.ID, id = "section")
    public static WebElement subject1;
    @FindBy(how=How.XPATH, xpath = "//*[@id='content']/div/div/div[2]/form/div[2]/div[2]/div/label/input")
    public static  WebElement gender1;
    @FindBy(how = How.ID, id = "name-input-field")
    public static WebElement firstname1;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"content\"]/div/div/div[2]/form/div[3]/div[3]/input")
    public static WebElement lastname1;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"datepicker\"]")
    public static WebElement dateofbirth1;
    @FindBy(how = How.ID, id = "city")
    public static WebElement city1;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"content\"]/div/div/div[2]/form/div[4]/div[4]/input")
    public static WebElement postcode1;
    @FindBy(how = How.ID, id = "address")
    public static WebElement address1;
    @FindBy(how = How.ID, id = "phone")
    public static WebElement phone1;
    @FindBy(how = How.ID, id = "email")
    public static WebElement email1;
    @FindBy(how = How.ID, id = "password")
    public static WebElement pwd;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\'content\']/div/div/div[2]/form/div[9]/div[1]/button")
    public static WebElement submit;
    
}
