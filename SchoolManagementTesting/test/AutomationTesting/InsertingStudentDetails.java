/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AutomationTesting;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static AutomationTesting.LogIN.driver;
/**
 *
 * @author Gayatree
 */
public class InsertingStudentDetails {
    @Test
    public static void InsertingStudentDetails() throws AWTException, InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement find=(WebElement) js.executeScript("retrun document.querySeelector('input[id=\'file\']).shadowRoot",js);
        find.click();
        String file = "C:\\Users\\Gayatree\\Downloads\\Student.xlsx";
        StringSelection selection=new StringSelection(file);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        WebElement inserting=LogIN.driver.findElement(By.xpath("//*[@id=\"excel-upload-box\"]/form/input[2]"));
        inserting.click();
    }
}