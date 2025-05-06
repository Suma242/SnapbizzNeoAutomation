package ObjectRepository;


	import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.appium.java_client.windows.WindowsDriver;

	public class BillingCartPage {

	    private WindowsDriver<WebElement> driver;

	    public BillingCartPage(WindowsDriver<WebElement> driver) {
	        this.driver = driver;
	    }

	    // Locators
	    public WebElement getProdAutoSugg() {
	        return driver.findElementByName("SnapBilling.Services.AppServices.ProductPackCompact");
	    }
	    
	    public WebElement getQty() {
	        return driver.findElementByAccessibilityId("QuantityTextbox");
	    }
	    
	    public WebElement getOkBtn() {
	        return driver.findElementByAccessibilityId("okBtn");
	    }

	    public WebElement getTagCust() {
	        return driver.findElementByAccessibilityId("BillingTab");
	    }

	    public WebElement getTagCustSearch() {
	        return driver.findElementByName("Search For Customer");
	    }

	    public WebElement getCustAutoSugg() {
	        return driver.findElementByName("SnapBilling.Services.AppServices.CustomerViewInfo");
	    }
	    	    
	    public WebElement getaddPaymentBtn() {
	        return driver.findElementByName("Add Payments");
	    }

	    public WebElement getPaymentMethod() {
	        return driver.findElementByAccessibilityId("PaymentModeCombo");
	    }
	    
	    public WebElement getPaymenttype() {
	        return driver.findElementByAccessibilityId("PaymentType");
	    }
	    
	    
	    public WebElement getAmount() {
	        return driver.findElementByAccessibilityId("Amount");
	    }
	    
	    public WebElement getPaymentSaveBtn() {
	        return driver.findElementByName("Save");
	    }
	    
	    public WebElement getPaymentCancelBtn() {
	        return driver.findElementByName("Cancel");
	    }
	    
	    public WebElement getSaveBtn() {
	        return driver.findElementByAccessibilityId("SaveBtn");
	    }
	       
	    public WebElement getCashBtn() {
	        return driver.findElementByAccessibilityId("CashBox");
	    }
	    
	    
	    public WebElement getNetAmount() {
	        return driver.findElementByName("MrpTextBox");
	    }
	    
	    
	    

	    // Business Logic
	    public void cartBilling(String productName, String customerName) throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        Actions actions = new Actions(driver);

	        // Focus the search field using Ctrl + F
	        actions.keyDown(Keys.CONTROL)
	               .sendKeys("f")
	               .keyUp(Keys.CONTROL)
	               .perform();
	        Thread.sleep(500); // Wait for search field to gain focus
	        actions.sendKeys(productName).perform();

	        wait.until(ExpectedConditions.elementToBeClickable(getProdAutoSugg()));
	        getProdAutoSugg().click();
	        
	        wait.until(ExpectedConditions.elementToBeClickable(getQty()));
	        getQty().click();
	        
	        wait.until(ExpectedConditions.elementToBeClickable(getOkBtn()));
	        getOkBtn().click();
	        
	        Thread.sleep(500);
	        
	        actions.keyDown(Keys.CONTROL)
            .sendKeys("n")
            .keyUp(Keys.CONTROL)
            .perform();
             Thread.sleep(500); // Wait for search field to gain focus
             actions.sendKeys(customerName).perform();

	        wait.until(ExpectedConditions.elementToBeClickable(getCustAutoSugg()));
	        getCustAutoSugg().click();
	        
	        Thread.sleep(500);
	        
	        wait.until(ExpectedConditions.elementToBeClickable(getaddPaymentBtn()));
	        getaddPaymentBtn().click();
	        
            WebElement payMdropdown = getPaymentMethod();
            
            payMdropdown.click();
            driver.findElementByName("Digital").click();
            
	        Thread.sleep(200); 

	        WebElement payTdropdown = getPaymenttype();
	        payTdropdown.click();
	        driver.findElementByName("PhonePe").click();
            

            wait.until(ExpectedConditions.elementToBeClickable(getAmount()));
	        getAmount().sendKeys(" 500");
	        
	        Thread.sleep(500); 

	        wait.until(ExpectedConditions.elementToBeClickable(getPaymentSaveBtn()));
	        getPaymentSaveBtn().click();
	        
	        Thread.sleep(100);

	        wait.until(ExpectedConditions.elementToBeClickable(getSaveBtn()));
	        getSaveBtn().click();
	    }
	    
	    public void creditBilling(String productName, String customerName) throws Throwable {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, 10);
	        Actions actions = new Actions(driver);

	        // Focus the search field using Ctrl + F
	        //Search product
	        actions.keyDown(Keys.CONTROL)
	               .sendKeys("f")
	               .keyUp(Keys.CONTROL)
	               .perform();
	        Thread.sleep(500); // Wait for search field to gain focus
	        actions.sendKeys(productName).perform();

	        wait.until(ExpectedConditions.elementToBeClickable(getProdAutoSugg()));
	        getProdAutoSugg().click();
	        
	        wait.until(ExpectedConditions.elementToBeClickable(getQty()));
	        getQty().click();
	        
	        wait.until(ExpectedConditions.elementToBeClickable(getOkBtn()));
	        getOkBtn().click();
	        
	        Thread.sleep(500);
	        
	        //Tag Customer
	        actions.keyDown(Keys.CONTROL)
            .sendKeys("n")
            .keyUp(Keys.CONTROL)
            .perform();
             Thread.sleep(500); // Wait for search field to gain focus
             actions.sendKeys(customerName).perform();

	        wait.until(ExpectedConditions.elementToBeClickable(getCustAutoSugg()));
	        getCustAutoSugg().click();	        
	        Thread.sleep(500);
	        
			getCashBtn().click();
			getCashBtn().sendKeys("0");
			
			getSaveBtn().click();
		}
}
