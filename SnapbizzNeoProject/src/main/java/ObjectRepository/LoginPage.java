package ObjectRepository;
	import io.appium.java_client.windows.WindowsDriver;
	import io.appium.java_client.MobileBy;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import java.time.Duration;

	import FileUtility.FileUtility;

	public class LoginPage {

	    private WindowsDriver<WebElement> driver;
	    private FileUtility fu = new FileUtility();

	    // Constructor
	    public LoginPage(WindowsDriver<WebElement> driver) {
	        this.driver = driver;
	    }

	    // Element Locators
	    public WebElement getUsernameField() {
	        return driver.findElementByAccessibilityId("userName");
	    }

	    public WebElement getPasswordField() {
	        return driver.findElementByAccessibilityId("password");
	    }

	    public WebElement getEyeIcon() {
	        return driver.findElementByAccessibilityId("RevealButton");
	    }

	    public WebElement getOkButton() {
	        return driver.findElementByClassName("Button");
	    }

	    public WebElement getCreateNewSessionButton() {
	        return driver.findElementByAccessibilityId("PrimaryButton");
	    }

	    public WebElement getContinueButton() {
	        return driver.findElementByAccessibilityId("continueButton");
	    }

	    public WebElement getSubmitButton() {
	        return driver.findElementByAccessibilityId("Submit");
	    }

	    // Business Logic  
	    public void loginToApp() throws Throwable {
	        String USERNAME = fu.getDataFromPropertiesFile("username");
	        String PASSWORD = fu.getDataFromPropertiesFile("password");

	        getUsernameField().sendKeys(USERNAME);
	        getPasswordField().clear();
	        getPasswordField().sendKeys(PASSWORD);
	        getEyeIcon().click();
	        getOkButton().click();

	        // Optional: handle session screen or continue buttons if needed
	         getCreateNewSessionButton().click();
	         //getContinueButton().click();

	         getSubmitButton().click();

	        System.out.println("Logged in successfully");
	    }
	}