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
public class StudentBioDataObject {
    @FindBy(how = How.XPATH, xpath = "//*[@id='search']")
    public static WebElement searchid;
    @FindBy(how = How.XPATH,xpath = "//*[@id=\"table\"]/tbody/tr[1]/td[13]/a[2]/i")
    public static WebElement viewing;
    @FindBy(how = How.ID,id = "address")
    public static WebElement address;
    @FindBy(how = How.XPATH,xpath = "//*[@id=\"myModal\"]/div/div/div[3]/button[2]")
    public static WebElement savedata;
    @FindBy(how = How.XPATH,xpath = "//*[@id=\"myModal\"]/div/div/div[3]/button[1]")
    public static WebElement close;
}
