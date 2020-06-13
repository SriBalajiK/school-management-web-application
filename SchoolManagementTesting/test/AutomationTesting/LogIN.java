/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AutomationTesting;

import PageObject.LogInObject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.TestException;
import org.testng.TestNGException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Gayatree
 */
public class LogIN {
    static WebDriver driver;
    
    @Test()
    public static void LogIN() {
        System.setProperty("webdriver.chrome.driver","E:\\software\\chromedriver_win32_1\\chromedriver.exe");
        Reporter.log("Browser is launched");
        driver=new ChromeDriver();
        driver.navigate().to("http://localhost/school-management-web-application/index.php?page=4");
        Reporter.log("Successfully Navigated to Login Page");
    }
    
    @DataProvider(name="logindatas")
    public  String[][] loginDataProvider() throws IOException, FileNotFoundException, BiffException{
        String[][] data = getlogindetail();
        return  data;
    }   
    
    public String[][] getlogindetail() throws FileNotFoundException, IOException, BiffException{
        FileInputStream excel=new FileInputStream("C:\\Users\\Gayatree\\Desktop\\datas.xls");
        Workbook workbook=Workbook.getWorkbook(excel);
        Sheet sheet=workbook.getSheet(0);
        int rowcout=sheet.getRows();
        int columncout=sheet.getColumns();
        String testdata[][]=new String[rowcout-1][columncout];
        for (int i = 1; i <rowcout; i++) {
            for (int j = 0; j < columncout; j++) {
                testdata[i-1][j]=sheet.getCell(j, i).getContents();
            }
        }
        return testdata;
    }
    @Test(dataProvider = "logindatas")
    public static void logindata(String uName , String pWord) {
        PageFactory.initElements(driver, LogInObject.class);
        String username=uName;
        String password=pWord;        
        //WebElement email=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/form/div[1]/input"));
        //LogInObject.email.sendKeys("admin@gmail.com");
        try{
        LogInObject.email.sendKeys(username);
        Reporter.log("Login Text Box Identifed & Email Entered");
        //WebElement password=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/form/div[2]/input"));        
        LogInObject.password.sendKeys(password);
        Reporter.log("Password Box is Identified and Pwd Entered");
        //WebElement ts=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/form/div[3]/label/input"));
        LogInObject.ts.click();
        Reporter.log("Terms & Conditions Box Found and clicked");
        //WebElement button=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/form/div[4]/button"));
       LogInObject.login.click();
       Reporter.log("Sign In Button Identified And Entered");
        //System.out.println("exception = " + e);
  
        if(uName.equals("admin@gmail.com") && pWord.equals("admin")){
            //WebElement email=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/form/div[1]/input"));         
       Reporter.log("Login Success");
       Reporter.getCurrentTestResult();
        //driver.navigate().to("http://localhost/school-management-web-application/index.php?page=4");
        //driver.quit();
       WebElement marks=driver.findElement(By.className("dropdown-toggle"));
       marks.click();
       WebElement markentryselection=driver.findElement(By.xpath("//ul//ul/li//a"));
       markentryselection.click();
       WebElement classsection=driver.findElement(By.xpath("//select//option[@value='Eleven']"));
       classsection.click();
       WebElement department=driver.findElement(By.xpath("//select//option[@value='Science']"));
       department.click();
       WebElement ok=driver.findElement(By.xpath("//*[@id=\"nav-after\"]/div/div/div/form/button"));
       ok.click();
        }
        else{
            System.out.println("Incorrect detail provided");
        }
            
    }
        catch(NoSuchElementException e)
                {
                    System.out.println("exception ="+ e);
                }
    }
}