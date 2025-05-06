package ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.windows.WindowsDriver;

public class AddProduct_Page {
	
	private WindowsDriver<WebElement> driver;

    public AddProduct_Page(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }

    public WebElement getBarcodeField() {
        return driver.findElementByAccessibilityId("BarcodeText");
    }

    public WebElement getProductNameField() {
        return driver.findElementByAccessibilityId("ProductNameTextBox");
    }

    public WebElement getShortNameField() {
        return driver.findElementByName("Short Name");
    }

    public WebElement getCategoryDropdown() {
        return driver.findElementByAccessibilityId("parentCategoryComboBox");
    }

    public WebElement getSubCategoryDropdown() {
        return driver.findElementByAccessibilityId("subCategoryComboBox");
    }

    public WebElement getPurchasePriceField() {
        return driver.findElementByName("Purchase Price");
    }

    public WebElement getMrpField() {
        return driver.findElementByName("MRP");
    }

    public WebElement getUomField() {
        return driver.findElementByAccessibilityId("UomCombobox");
    }

    public WebElement getSellingPrice1Field() {
        return driver.findElementByName("Selling Price 1");
    }

    public WebElement getHsnCodeField() {
        return driver.findElementByName("HSN Code");
    }

    public WebElement getQuickAddButton() {
        return driver.findElementByAccessibilityId("quickAdd");
    }

    public WebElement getSaveButton() {
        return driver.findElementByName("Save");
    }

    public WebElement getCancelButton() {
        return driver.findElementByName("Cancel");
    }
    
    //Action
    
    public void createProducts(String barcode,String productName,String purchasePrice,  String mrp, String uom) throws Exception {
    	
    	getBarcodeField().clear();
    	getBarcodeField().sendKeys(barcode);
    	
    	getProductNameField().clear();
    	getProductNameField().sendKeys(productName);
    	
    	getPurchasePriceField().clear();
    	getPurchasePriceField().sendKeys(purchasePrice);
    	
    	// MRP - force focus using Actions
	    WebElement mrpField = getMrpField();
	    Actions act= new Actions(driver);
	    act.moveToElement(mrpField).click().perform();
	    Thread.sleep(300); // Ensure focus moved
	    mrpField.clear();
	    mrpField.sendKeys(mrp);
	    System.out.println("Focused on: " + driver.switchTo().activeElement().getAttribute("Name"));

    	
    	
//    	getMrpField().click();
//    	getMrpField().clear();
//    	getMrpField().sendKeys(mrp);
//    	
    	WebElement dropdown = getUomField();
        dropdown.click();
        dropdown.sendKeys(uom);
        dropdown.sendKeys(Keys.ENTER);
    	
    	getSaveButton().click();
    	
    }

}
