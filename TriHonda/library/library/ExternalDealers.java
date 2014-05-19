
package library;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ExternalDealers{
Sheet s;
WebDriver driver;
int count=0;
static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
public static final String USERNAME = "earlwillis1";
public static final String AUTOMATE_KEY = "XsPyFTirN4mH8aCLMB9A";
public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
String local=(new java.io.File("").getAbsolutePath());
String data="" + local + "/" + "externaldealers.xls";
String name ="";
@Before
public void setUp()
{


}


@Test







public void searchGoogle() throws Exception {

	DesiredCapabilities caps = DesiredCapabilities.firefox();
	  caps.setCapability("browser", "FireFox");
	  caps.setCapability("browser_version", "22.0");
	  caps.setCapability("os", "Windows");
	  caps.setCapability("os_version", "7");
	  caps.setCapability("browserstack.debug", "true");
	  
	  WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	  driver.manage().window().maximize();
	    driver.get("http://google.com");
	    
   InputStream  fi= new FileInputStream(data);
  Workbook w = Workbook.getWorkbook(fi);
  s = w.getSheet(0);
String myTitle = driver.getTitle();
//Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
//String browserName = caps.getBrowserName();
//String browserVersion = caps.getVersion();
//System.out.println(browserName+" "+browserVersion);
//System.out.println("==========");

for(int row=1; row <=s.getRows();row++) {
  
  try {


String urlname = s.getCell(0, row).getContents();
String dealer = s.getCell(2, row).getContents();
driver.get(urlname);
count+=1;
driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);


java.util.List<WebElement> list=driver.findElements(By.xpath("//a"));
 

for(WebElement link:list)                             
{
  System.out.println(link.getText());

}




Thread.sleep(1000);
try {
        (new Robot()).keyPress(java.awt.event.KeyEvent.VK_ENTER);

         (new Robot()).keyRelease(java.awt.event.KeyEvent.VK_ENTER);
         } catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

    File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(scrFile1, new File("ExternalPages" + "/" + row + "_found" + dealer +".png"));
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

  } catch (Exception ex){
      
      
      
      
      continue;
    }  
}
}



private boolean isElementPresent(By cssSelector) {
// TODO Auto-generated method stub
return false;
}


@After
public void tearDown() throws Exception {
	
    driver.quit();
    
  }
 }

