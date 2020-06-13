/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AutomationTesting;

import static AutomationTesting.LogIN.driver;
import PageObject.MarkViewObject;
import PageObject.StudentRegistrationObjects;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Gayatree
 */
public class ResultViewing {
    @DataProvider(name = "resultview")
    public String[][] resultDataProvider() throws IOException, FileNotFoundException, BiffException {
        String[][] data = resultdetails();
        return data;
    }

    // iterating excel data and storing in markdata[][]
    public String[][] resultdetails() throws FileNotFoundException, IOException, BiffException {
        FileInputStream excel = new FileInputStream("C:\\Users\\Gayatree\\Desktop\\datas.xls");
        Workbook workbook = Workbook.getWorkbook(excel);
        Sheet sheet = workbook.getSheet(3);
        int rowcout = sheet.getRows();
        int columncout = sheet.getColumns();
        String markdata[][] = new String[rowcout - 1][columncout];
        for (int i = 1; i < rowcout; i++) {
            for (int j = 0; j < columncout; j++) {
                markdata[i - 1][j - 0] = sheet.getCell(j, i).getContents();
            }
        }
        return markdata;
    }
@BeforeTest
public static void reuslt(){
    driver.navigate().to("http://localhost/school-management-web-application/index.php?page=3");
}
    // web table and excel roll number will be matched to fill the mark details.
    @Test(dataProvider = "resultview")
    public static void ResultViewing(String clas,String rollnumber, String subject,String gender,String firstname, String lastname,String dateofbirth, String city, String postcode,String address, String phone, String email) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    //    List<WebElement> columncount = driver.findElements(By.xpath("//*[@id='table']//tr[1]//td//input")); // web page column cout
    //    List<WebElement> rollnumber = driver.findElements(By.xpath("//*[@id='table']//tbody//tr//td[1]//input"));//web page row count    
        PageFactory.initElements(driver, StudentRegistrationObjects.class);
        Select  s1=new Select(StudentRegistrationObjects.education);
        s1.selectByValue(clas);
        
        Select sub=new Select(StudentRegistrationObjects.subject1);
        sub.selectByValue(subject);
        
        StudentRegistrationObjects.id.sendKeys(rollnumber);
        Thread.sleep(5000);
        WebElement subit=driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div/form/div[4]/div[1]/button"));
        subit.click();
       Thread.sleep(5000);
       WebElement reset=driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div/form/div[4]/div[2]/button"));
               reset.click();
               Thread.sleep(5000);
    }
    
}
