/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AutomationTesting;
import static AutomationTesting.LogIN.driver;
import PageObject.MarkViewObject;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 *
 * @author Gayatree
 */
public class MarkView {
    @Test
    public static void MarkView() throws AWTException, IOException, InterruptedException {
        
        PageFactory.initElements(driver, MarkViewObject.class);
       //WebElement marks=driver.findElement(By.className("dropdown-toggle"));
       MarkViewObject.marks.click();
       //WebElement markview=driver.findElement(By.xpath("//ul//ul//li[2]//a"));
        MarkViewObject.markview.click();
       //WebElement classsection1=driver.findElement(By.xpath("//select//option[@value='Eleven']"));
       MarkViewObject.classsection1.click();
       //WebElement department1=driver.findElement(By.xpath("//select//option[@value='Science']"));
       MarkViewObject.department1.click();
       //WebElement view=driver.findElement(By.xpath("//*[@id=\"nav-after\"]/div/div/div/form/button"));
       MarkViewObject.view.click();
       //WebElement commentupdate=driver.findElement(By.xpath("//*[@id=\"table_in\"]/tbody/tr[1]/td[9]/input"));
       Thread.sleep(5000);
       MarkViewObject.commentupdate.clear();
       MarkViewObject.commentupdate.sendKeys("Good");
       //WebElement updatedata=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/button"));
       MarkViewObject.updatedata.click();
       Robot robots=new Robot();
        Rectangle rectangle1=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage sourcefilecapture1 = robots.createScreenCapture(rectangle1);
        File destinationfile1=new File("D://output//viewing marking.png");
        ImageIO.write(sourcefilecapture1, "png", destinationfile1);
    }   
}