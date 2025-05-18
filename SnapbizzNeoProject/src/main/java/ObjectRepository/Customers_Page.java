package ObjectRepository;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class Customers_Page {
	
	private WindowsDriver<WebElement> driver;
    public Customers_Page(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }

    // Locators
    public WebElement getSearchBox() {
        return driver.findElementByAccessibilityId("search");
    }
    
    public WebElement getImportBtn() {
        return driver.findElementByAccessibilityId("ImportOptionsBtn");
    }
    
    public WebElement getBillsOption() {
        return driver.findElementByAccessibilityId("BillItem");
    }
    
    
    public WebElement getTaggedCustomerLabel() {
        return driver.findElementByXPath("//Text[following-sibling::Text[@Name='Total Due :']]");
    }
    
//    public WebElement getTaggedCustomerLabel() {
//        return driver.findElementByClassName("TextBlock");
//    }
   
    public WebElement getAmt() {
        return driver.findElementByName("₹ 500");
    }
    

}
