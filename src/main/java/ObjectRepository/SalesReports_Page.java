package ObjectRepository;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class SalesReports_Page {
	
	private WindowsDriver<WebElement> driver;
    public SalesReports_Page(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }
    
    //sales register report
    public WebElement getSalesRegisterReport() {
    	return driver.findElementByAccessibilityId("sales_register_report");
        }
    
    public WebElement getPreviewBtn() {
    	return driver.findElementByName("Preview");
        }

}
