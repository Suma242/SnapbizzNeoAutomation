package ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;

public class PurchaseReport_Page {
	
	private WindowsDriver<WebElement> driver;
    public PurchaseReport_Page(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }
    
    //sales register report
    public WebElement getPurchaseReport() {
    	return driver.findElementByAccessibilityId("purchase_report");
        }
    
    public WebElement getPreviewBtn() {
    	return driver.findElementByName("Preview");
        }
    
    
    
  
  
}
