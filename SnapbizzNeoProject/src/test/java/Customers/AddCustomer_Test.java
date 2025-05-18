package Customers;

import org.testng.annotations.Test;

import BaseClass.BaseTest;
import FileUtility.ExcelUtility;
import ObjectRepository.Add_CustomerPage;
import ObjectRepository.HomePage;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class AddCustomer_Test extends BaseTest {

	WebDriverUtility wu = new WebDriverUtility();
	JavaUtility ju = new JavaUtility();
	ExcelUtility eu = new ExcelUtility();

	//SMOKE Test
	@Test
	public void addCustomers() throws Throwable {
		wu.waitForPageLoad(driver);

		// Step 1: Login to app

		// Step 2: Navigate to customers module
		HomePage hp = new HomePage(driver);
		hp.clickOpenMenu();
		Thread.sleep(200);
		hp.clickCustomer();

		// Step 3: Read data from excel and click on add customers
		int rowCount = eu.getRowCount("customerSheet");
		for (int i = 1; i <= rowCount; i++) {
			String custName = eu.getDataFromExcel("customerSheet", i, 0) + ju.getRandomNumber();
			String custPhone = eu.getDataFromExcel("customerSheet", i, 1) + ju.getRandomNumber();

			Add_CustomerPage ac = new Add_CustomerPage(driver);
			ac.createCustumer(custPhone, custName);
		}
		Thread.sleep(500);

	}

	//REGRESSION Test
	@Test
	public void addCustomerWithMoreInformation() throws Throwable {
		wu.waitForPageLoad(driver);

		// Login to app

		// Navigate to customer module
		HomePage hp = new HomePage(driver);
		hp.clickOpenMenu();
		hp.clickCustomer();

		// Read row count
		int rowCount = eu.getRowCount("customerSheet");

		for (int i = 1; i <= rowCount; i++) {
			String custName = eu.getDataFromExcel("customerSheet", i, 0) + ju.getRandomNumber();
			String custPhone = eu.getDataFromExcel("customerSheet", i, 1) + ju.getRandomNumber();
			String custAltPhone = eu.getDataFromExcel("customerSheet", i, 2);
			String email = eu.getDataFromExcel("customerSheet", i, 3);
			String memId = eu.getDataFromExcel("customerSheet", i, 4) + ju.getRandomNumber();
			String Gender = eu.getDataFromExcel("customerSheet", i, 5);

			Add_CustomerPage ac = new Add_CustomerPage(driver);
			ac.createCustumerWithMemID(custPhone, custAltPhone, custName, email, memId, Gender);
		}
		Thread.sleep(500);

	}
}
