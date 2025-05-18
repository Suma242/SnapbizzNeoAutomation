package WebDriverUtility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.appium.java_client.windows.WindowsDriver;

public class WebDriverUtility {
	
	 private WindowsDriver<WebElement> driver;
	 //private WindowsDriver<WebElement> driver;
	
   public void waitForPageLoad(WindowsDriver<WebElement> driver) {
	  // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
		
		public Actions action(WindowsDriver<WebElement> driver ) {
			Actions act = new Actions(driver);
			return act;		
		}
		

		public void mouseMoveOnElement(WindowsDriver<WebElement> driver, WebElement element) {
			action(driver).moveToElement(element).perform();
		}
	
		public void doubleclick(WindowsDriver<WebElement> driver, WebElement element ){
			action(driver).doubleClick(element).perform();			
		}
		
		public void dragAndDrop(WindowsDriver<WebElement> driver, WebElement src , WebElement dest ){
			action(driver).dragAndDrop(src, dest).perform();		
		}
		
		public void rightClick(WindowsDriver<WebElement> driver, WebElement element ){
			action(driver).contextClick().perform();			
		}
		
		public void sendkeys(WindowsDriver<WebElement> driver, WebElement element , String text){
			action(driver).sendKeys(text).perform();
		}
		
		public void scrollToElement(WindowsDriver<WebElement> driver, WebElement element){
			action(driver).moveToElement(element).perform();
		}
		
		
		
		public void webElementScreenshot(WebElement element , String name) throws IOException {
			JavaUtility jLib = new JavaUtility();
			File src = element.getScreenshotAs(OutputType.FILE);
			File dest = new File("./Screenshot/" +name+ jLib.getSystemDateyyyyMMdd()+".png");
		    org.openqa.selenium.io.FileHandler.copy(src, dest);
			
			
		}
		
		public void webPageScreenshot(WindowsDriver<WebElement> driver ,WebElement element , String pagename) throws IOException {
			JavaUtility jLib = new JavaUtility();
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./Screenshot/; "+pagename+ jLib.getSystemDateyyyyMMdd()+".png");
			org.openqa.selenium.io.FileHandler.copy(src, dest);
			
			
		}
		public void javaScriptScrollDown(WindowsDriver<WebElement> driver , int scrollamount) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, "+ scrollamount+ ");");

		}
		
		public void scrollUntilEleToBeVisible(WindowsDriver<WebElement> driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			int y = element.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+y+");");
		}

}
