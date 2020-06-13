/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AutomationTesting;

import static AutomationTesting.LogIN.driver;
import PageObject.StudentBioDataObject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Gayatree
 */
public class StudentBioData {
    

    @DataProvider(name = "studentbio")
    public String[][] loginDataProvider() throws IOException, FileNotFoundException, BiffException {
        String[][] data = studentbiodata();
        return data;
    }

    // iterating excel data and storing in markdata[][]
    public String[][] studentbiodata() throws FileNotFoundException, IOException, BiffException {
        FileInputStream excel = new FileInputStream("C:\\Users\\Gayatree\\Desktop\\datas.xls");
        Workbook workbook = Workbook.getWorkbook(excel);
        Sheet sheet = workbook.getSheet(3);
        int rowcout = sheet.getRows();
        int columncout = sheet.getColumns();
        String studata[][] = new String[rowcout - 1][columncout];
        for (int i = 1; i <rowcout; i++) {
            for (int j = 0; j <columncout; j++) {
                studata[i - 1][j - 0] = sheet.getCell(j, i).getContents();
            }
        }
        return studata;
    }
        
        
        @Test(dataProvider = "studentbio")
        public void studentBioData(String Class_Name,String Roll,String	Section,String Gender,String FirstName,String LastName, String DateofBirth,String City,String PostCode,String Address,String Phone,String Email) throws InterruptedException{
       driver.navigate().to("http://localhost/school-management-web-application/index.php?page=2");
        PageFactory.initElements(driver, StudentBioDataObject.class);
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        //WebElement searchid=driver.findElement(By.xpath("//*[@id='search']"));
        StudentBioDataObject.searchid.sendKeys(Roll);
        //WebElement viewing=driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[13]/a[2]/i"));
        try{
        StudentBioDataObject.viewing.click();
        }
        catch(StaleElementReferenceException e){
            StudentBioDataObject.viewing.click();
            System.out.println(" Exception " + e);
            driver.quit();
        }
        //WebElement addressupdate=driver.findElement(By.id("address"));
        StudentBioDataObject.address.clear();
        StudentBioDataObject.address.sendKeys(City);
        //WebElement savechange=driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/button[2]"));
        StudentBioDataObject.savedata.click();
        Thread.sleep(3000);
        //WebElement close=driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/button[1]"));
        StudentBioDataObject.close.click();
        Thread.sleep(3000);
        driver.navigate().refresh();
    }
}