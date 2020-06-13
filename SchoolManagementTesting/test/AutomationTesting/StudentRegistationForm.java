package AutomationTesting;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import PageObject.StudentRegistrationObjects;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
public class StudentRegistationForm {
    
    @DataProvider(name = "StudentRegistrationData")
    public String[][] loginDataProvider() throws IOException, FileNotFoundException, BiffException {
        String[][] data = studentData();
        return data;
    }

    // iterating excel data and storing in markdata[][]
    public String[][] studentData() throws FileNotFoundException, IOException, BiffException {
        FileInputStream excel = new FileInputStream("C:\\Users\\Gayatree\\Desktop\\datas.xls");
        Workbook workbook = Workbook.getWorkbook(excel);
        Sheet sheet = workbook.getSheet(2);
        int rowcout = sheet.getRows();
        int columncout = sheet.getColumns();
        String studentDataDetails[][] = new String[rowcout - 1][columncout];
        for (int i = 1; i < rowcout; i++) {
            for (int j = 0; j < columncout; j++) {
                studentDataDetails[i - 1][j - 0] = sheet.getCell(j, i).getContents();
            }
        }
        return studentDataDetails;
    }

    static  WebDriver driver;
    @BeforeTest
    public static void StudentRegistationForm() {
        System.setProperty("webdriver.chrome.driver","E:\\software\\chromedriver_win32_1\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://localhost/school-management-web-application/index.php");
        WebElement home=driver.findElement(By.linkText("Home"));
        home.click();
        driver.manage().window().maximize();
    }
    
    @Test(dataProvider = "StudentRegistrationData")
    public static void Datafilling(String clas,String rollnumber, String subject,String gender,String firstname, String lastname,String dateofbirth, String city, String postcode,String address, String phone, String email, String password) throws InterruptedException{
        PageFactory.initElements(driver, StudentRegistrationObjects.class);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        //WebElement education=driver.findElement(By.id("stc_1"));
        Select  s1=new Select(StudentRegistrationObjects.education);
        s1.selectByValue(clas);
        //WebElement id=driver.findElement(By.id("roll"));
        StudentRegistrationObjects.id.sendKeys(rollnumber);
        //WebElement subject1=driver.findElement(By.id("section"));
        Select sub=new Select(StudentRegistrationObjects.subject1);
        sub.selectByValue(subject);
        //WebElement gender1=driver.findElement(By.xpath("//*[@id='content']/div/div/div[2]/form/div[2]/div[2]/div/label/input"));
        String gm = StudentRegistrationObjects.gender1.getAttribute("value");
        //System.out.println("Gender Identified as = " + gender1.getAttribute("value") + "\t gm = " + gm);
        if (gm.equals(gender)) {
            JavascriptExecutor executor=(JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click()", StudentRegistrationObjects.gender1);
        }
        //WebElement firstname1=driver.findElement(By.id("name-input-field"));
        StudentRegistrationObjects.firstname1.sendKeys(firstname);
        //WebElement lastname1=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/form/div[3]/div[3]/input"));
        StudentRegistrationObjects.lastname1.sendKeys(lastname);
//        WebElement dob=driver.findElement(By.id("datepicker"));
//        dob.click();
//        WebElement month=driver.findElement(By.className("ui-datepicker-month"));
//        month.click();
//        Select mth=new Select(month);
//        mth.selectByValue("8");
//        WebElement year=driver.findElement(By.className("ui-datepicker-year"));
//        Select yr=new Select(year);
//        yr.selectByValue("2010");
//        WebElement year1=driver.findElement(By.className("ui-datepicker-year"));
//        Select yr1=new Select(year1);
//        yr1.selectByValue("2000");
//        WebElement year2=driver.findElement(By.className("ui-datepicker-year"));
//        Select yr2=new Select(year2);
//        yr2.selectByValue("1990");
//        WebElement date=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a"));
//        date.click();
        //WebElement dateofbirth1=driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
        StudentRegistrationObjects.dateofbirth1.sendKeys(dateofbirth + "\t");
        //WebElement city1=driver.findElement(By.id("city"));
        Select cty=new Select(StudentRegistrationObjects.city1);
        cty.selectByValue(city);
        //WebElement postcode1=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[2]/form/div[4]/div[4]/input"));
        StudentRegistrationObjects.postcode1.sendKeys(postcode);
        //WebElement address1=driver.findElement(By.id("address"));
        StudentRegistrationObjects.address1.sendKeys(address);
        //WebElement phone1=driver.findElement(By.id("phone"));
        StudentRegistrationObjects.phone1.sendKeys(phone);
        //WebElement email1=driver.findElement(By.id("email"));
        StudentRegistrationObjects.email1.sendKeys(email);
        //WebElement pwd=driver.findElement(By.id("password"));
        StudentRegistrationObjects.pwd.sendKeys(password);
//        WebElement submit=driver.findElement(By.xpath("//*[@id=\'content\']/div/div/div[2]/form/div[9]/div[1]/button"));
        StudentRegistrationObjects.submit.click();
    }
    @AfterTest
    public static void closebrowser(){
        driver.quit();
    }
}