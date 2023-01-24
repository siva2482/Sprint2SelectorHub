package rough;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class roughClass {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
    driver  =new ChromeDriver();
   driver.manage().window().maximize();
   driver.get("https://selectorshub.com/xpath-practice-page/");
   WebElement ele=driver.findElement(By.xpath("//*[local-name()='svg' and @iconid='editon']/*[local-name()='path'][1]"));
   Actions action=new Actions(driver);
   action.moveToElement(ele).
   click().build().perform();
   Thread.sleep(3000);
  WebElement fname= driver.findElement(By.xpath("//input[@placeholder='First Enter name']"));
  fname.sendKeys("Naveen");
  JavascriptExecutor js=(JavascriptExecutor)driver;
  js.executeScript("document.querySelector(\"input[placeholder='Enter Last name']\").disabled=false");
  driver.findElement(By.xpath("//input[@placeholder='Enter Last name']")).sendKeys("kumar");
  Thread.sleep(3000);
  WebElement chkbutton=driver.findElement(By.xpath("//div[@class='dropdown']//button [@class='dropbtn']"));
  action.moveToElement(chkbutton);
  Thread.sleep(3000);
  WebElement submenu=driver.findElement(By.xpath("//div[@class='dropdown']//div[@class='dropdown-content']//a[contains(text(),'Join Training')]"));
  action.moveToElement(submenu).click().build().perform();
 String parent= driver.getWindowHandle();
 Set<String> set=driver.getWindowHandles();
 driver.switchTo().window(parent);
 WebElement selectcar=driver.findElement(By.id("cars"));
 Select s=new Select(selectcar);
 s.selectByValue("audi");
 
 driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-da25664 elementor-widget elementor-widget-html']//table[@id='resultTable']//tbody//tr[2]//td[2]//a[contains(text(),'Jasmine.Morgan')]")).click();
 driver.switchTo().window(parent);
 driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-da25664 elementor-widget elementor-widget-html']//table[@id='resultTable']//tbody//tr[2]//td[2]//a[contains(text(),'Jasmine.Morgan')]//preceding::td[1]//input")).click();
 //Thread.sleep(3000);
 driver.switchTo().frame("pact");
 /*WebElement shadowHost = driver.findElement(By.cssSelector("div#snacktime"));*/
 WebElement last=(WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('#snacktime').shadowRoot.querySelector('input')");
 js.executeScript("arguments[0].value='teaaaaaaaaa';",last);
 Thread.sleep(3000);
 WebElement lunch=(WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('#snacktime').shadowRoot.querySelector('#app2').shadowRoot.querySelector('input')");
 js.executeScript("arguments[0].value='biryani';",lunch);
 WebElement concept=(WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('#snacktime').shadowRoot.querySelector('#concepts')");
 concept.click();
 
 
 Actions act=new Actions(driver);
 act.sendKeys(Keys.TAB).perform();
 act.sendKeys("No XPATH").perform();
 
 
 //WebElement shadowroot=driver.findElement(By.cssSelector("#snacktime"));
 WebElement element1=(WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('#snacktime').shadowRoot.querySelector('#shadpact')");
 Thread.sleep(3000);
// WebElement frm=element1.findElement(By.cssSelector("#shadpact"));
 driver.switchTo().frame(element1);
 WebElement college=(WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('#opled')");
 college.click();
 
 
 Actions act1=new Actions(driver);
 act1.sendKeys(Keys.TAB).perform();
 act1.sendKeys("SASTRA").perform();
 //driver.findElement(By.xpath("//input[@id='college']")).sendKeys("sastra");
 driver.switchTo().defaultContent();
 driver.switchTo().frame("pact");
 WebElement coffee=(WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('#jest')");
 coffee.click();
 
 
 Actions act2=new Actions(driver);
 act1.sendKeys(Keys.TAB).perform();
 act1.sendKeys("LOVE COFFEE").perform();
 
 
  
	}
}
