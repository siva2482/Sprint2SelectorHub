package StepDef;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class selectorclass {
	
	public static WebDriver driver;
	  WebElement fname;
	 // Actions action=new Actions(driver);
	  String parent;
	@Given("User enters the application")
	public void user_enters_the_application() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
	    driver  =new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://selectorshub.com/xpath-practice-page/");
	    
	}

	@Then("User asserts the application")
	public void user_asserts_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals("https://selectorshub.com/xpath-practice-page/", driver.getCurrentUrl());
	    System.out.println("Landed on selectorts hub homepage");
	}

	@When("User enters names in disabled name textbox")
	public void user_enters_names_in_disabled_name_textbox() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement ele=driver.findElement(By.xpath("//*[local-name()='svg' and @iconid='editon']/*[local-name()='path'][1]"));
		   Actions action=new Actions(driver);
		   action.moveToElement(ele).
		   click().build().perform();
		   Thread.sleep(3000);
		   fname= driver.findElement(By.xpath("//input[@placeholder='First Enter name']"));
		  fname.sendKeys("Naveen");
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("document.querySelector(\"input[placeholder='Enter Last name']\").disabled=false");
		  driver.findElement(By.xpath("//input[@placeholder='Enter Last name']")).sendKeys("kumar");
		  Thread.sleep(3000);
	}

	@Then("User asserts textbox are enabled")
	public void user_asserts_textbox_are_enabled() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(fname.isEnabled());
	    System.out.println("Textbox got enabled");
	}
	@When("User checks out the available option")
	public void user_checks_out_the_available_option() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 WebElement chkbutton=driver.findElement(By.xpath("//div[@class='dropdown']//button [@class='dropbtn']"));
		 Actions action=new Actions(driver);
		  action.moveToElement(chkbutton);
		  Thread.sleep(3000);
		  WebElement submenu=driver.findElement(By.xpath("//div[@class='dropdown']//div[@class='dropdown-content']//a[contains(text(),'Join Training')]"));
		  action.moveToElement(submenu).click().build().perform();
		  parent= driver.getWindowHandle();
		 
	}

	@Then("verifies the new page and comes back")
	public void verifies_the_new_page_and_comes_back() {
	    // Write code here that turns the phrase above into concrete actions
		 Set<String> set=driver.getWindowHandles();
		/* for(String s:set)
		 {
			 if(!(s==parent))
			 {
				 driver.switchTo().window(s);
			Assert.assertEquals("https://selectorshub.com/bootcamp/", driver.getCurrentUrl());
			System.out.println("bootcamp reached");
		 }*/
		 driver.switchTo().window(parent);
		 Assert.assertEquals("https://selectorshub.com/xpath-practice-page/", driver.getCurrentUrl());
		 System.out.println("Selectorhub homepage reached back");
	}

	
	@When("User select the car")
	public void user_select_the_car() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement selectcar=driver.findElement(By.id("cars"));
		 Select s=new Select(selectcar);
		 s.selectByValue("audi");
	    
	}

	@Then("verifies his selection")
	public void verifies_his_selection() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Audi car selected");
	   
	}
	@When("User selects value from UsersTable")
	public void user_selects_value_from_users_table() {
	    // Write code here that turns the phrase above into concrete actions

		 driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-da25664 elementor-widget elementor-widget-html']//table[@id='resultTable']//tbody//tr[2]//td[2]//a[contains(text(),'Jasmine.Morgan')]")).click();
		 driver.switchTo().window(parent);
		 driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-da25664 elementor-widget elementor-widget-html']//table[@id='resultTable']//tbody//tr[2]//td[2]//a[contains(text(),'Jasmine.Morgan')]//preceding::td[1]//input")).click();
		 //Thread.sleep(3000);
	}

	@Then("verfies the home page")
	public void verfies_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("https://selectorshub.com/xpath-practice-page/", driver.getCurrentUrl());
		 System.out.println("Selectorhub homepage reached back,UsersTable selected");
	}
	
	@When("User enters shadow Elements in the homepage")
	public void user_enters_shadow_elements_in_the_homepage() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.switchTo().frame("pact");
		 /*WebElement shadowHost = driver.findElement(By.cssSelector("div#snacktime"));*/
		 WebElement last=(WebElement)((JavascriptExecutor)driver).executeScript("return document.querySelector('#snacktime').shadowRoot.querySelector('input')");
		 JavascriptExecutor js=(JavascriptExecutor)driver;
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

	@Then("verifies values")
	public void verifies_values() {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("Shadow elements entered");
	}


}
