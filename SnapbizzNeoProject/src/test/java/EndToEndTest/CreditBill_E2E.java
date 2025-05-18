package EndToEndTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseTest;
import FileUtility.ExcelUtility;
import ObjectRepository.Add_CustomerPage;
import ObjectRepository.BillingCartPage;
import ObjectRepository.Customers_Page;
import ObjectRepository.HomePage;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class CreditBill_E2E extends BaseTest {

	WebDriverUtility wu = new WebDriverUtility();
	JavaUtility ju = new JavaUtility();
	ExcelUtility eu = new ExcelUtility();

	@Test
	public void salesBill() throws Throwable {

		wu.waitForPageLoad(driver);

		// Step 1: Login to app

		// Step 2: Navigate to inventory module and click on add customer
		HomePage hp = new HomePage(driver);
		hp.clickOpenMenu();
		hp.clickCustomer();

		// Step 3: Read data from excel file and Create the customer and store the name
		// for validation later

		String custName = eu.getDataFromExcel("customerSheet", 1, 0) + ju.getRandomNumber();
		String custPhone = eu.getDataFromExcel("customerSheet", 1, 1) + ju.getRandomNumber();
		Add_CustomerPage ac = new Add_CustomerPage(driver);
		String createdCustomerName = ac.createCustumer(custPhone, custName); // Capture customer name

		Thread.sleep(500);

		hp.clickOpenMenu();

		// Step 4: Read data from excel file
		hp.clickCart();
		String productName = eu.getDataFromExcel("productSheet", 1, 0);

		BillingCartPage bp = new BillingCartPage(driver);
		bp.creditBilling(productName, createdCustomerName);

		hp.clickOpenMenu();
		hp.clickBills();
		Thread.sleep(500);

		hp.clickOpenMenu();
		hp.clickCustomer();

		// Search for the same customer
		Customers_Page cp = new Customers_Page(driver);
		cp.getSearchBox().sendKeys(createdCustomerName);
		cp.getSearchBox().sendKeys(Keys.ENTER);

		cp.getBillsOption().click();
		String dueAmount = cp.getAmt().getText();
		System.out.println("============================Due Amount is ===================: " + dueAmount);
	}

}
