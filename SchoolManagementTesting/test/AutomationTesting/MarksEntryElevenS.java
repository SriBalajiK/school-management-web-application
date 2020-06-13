    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutomationTesting;

import static AutomationTesting.LogIN.driver;
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
import org.testng.TestException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Gayatree
 */
// will store and return excel input data string[][] data & sends values to dataprovider "markdetails"
public class MarksEntryElevenS {

    @DataProvider(name = "markdetails")
    public String[][] loginDataProvider() throws IOException, FileNotFoundException, BiffException {
        String[][] data = getmarkdetails();
        return data;
    }

    // iterating excel data and storing in markdata[][]
    public String[][] getmarkdetails() throws FileNotFoundException, IOException, BiffException {
        FileInputStream excel = new FileInputStream("C:\\Users\\Gayatree\\Desktop\\datas.xls");
        Workbook workbook = Workbook.getWorkbook(excel);
        Sheet sheet = workbook.getSheet(1);
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

    // web table and excel roll number will be matched to fill the mark details.
    @Test(dataProvider = "markdetails")
    public static void ElevenScience(String roll_no, String subjects, String terms, String years, String theory_mark, String practical_mark, String commenting) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        List<WebElement> columncount = driver.findElements(By.xpath("//*[@id='table']//tr[1]//td//input")); // web page column cout
        List<WebElement> rollnumber = driver.findElements(By.xpath("//*[@id='table']//tbody//tr//td[1]//input"));//web page row count    
        try {
            for (int i = 0; i <= rollnumber.size(); i++) {
                int j = 2;
                if (rollnumber.get(i).getAttribute("value").equals(roll_no)) {
                    i++;
                    WebElement subject = driver.findElement(By.xpath("//*[@id='table']/tbody/tr[" + i + "]/td[" + j++ + "]/input"));
                    subject.sendKeys(subjects);

                    WebElement term = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[" + i + "]/td[" + j++ + "]/input"));
                    term.sendKeys(terms);

                    WebElement year = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[" + i + "]/td[" + j++ + "]/input"));
                    year.sendKeys(years);

                    WebElement theory = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[" + i + "]/td[" + j++ + "]/input"));
                    theory.sendKeys(theory_mark);

                    WebElement practical = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[" + i + "]/td[" + j++ + "]/input"));
                    practical.sendKeys(practical_mark);

                    WebElement comments = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[" + i + "]/td[" + j++ + "]/input"));
                    comments.sendKeys(commenting);
                }

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("array exception catched" + e);

        }
        
        
    }
    @AfterTest
    public static void saveData(){
        WebElement savedatas = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/button"));
        savedatas.click();
    }
}
