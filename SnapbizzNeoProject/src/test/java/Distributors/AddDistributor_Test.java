package Distributors;

import org.testng.annotations.Test;

import BaseClass.BaseTest;
import FileUtility.ExcelUtility;
import ObjectRepository.Add_CustomerPage;
import ObjectRepository.Add_DistributorPage;
import ObjectRepository.HomePage;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class AddDistributor_Test extends BaseTest {
	WebDriverUtility wu = new WebDriverUtility();
	JavaUtility ju = new JavaUtility();
	ExcelUtility eu = new ExcelUtility();

	@Test
	public void addDistributors() throws Throwable {
		wu.waitForPageLoad(driver);

		// Step 1: Login to app

		// Step 2: Navigate to Distributor module
		HomePage hp = new HomePage(driver);
		hp.clickOpenMenu();
		hp.clickDistributor();
		
		// Step 3: Read data from excel and click on add customers
				int rowCount = eu.getRowCount("distributorSheet");
				for (int i = 1; i <= rowCount; i++) {
					String DistName = eu.getDataFromExcel("distributorSheet", i, 0) + ju.getRandomNumber();
					String phoneNo = eu.getDataFromExcel("distributorSheet", i, 1) + ju.getRandomNumber();
					Add_DistributorPage ad= new Add_DistributorPage(driver);
					ad.addDistributors(phoneNo, DistName);
				}
				Thread.sleep(500);
/**
		// Step 3: Read data from excel and click on add distributor
		int rowCount = eu.getRowCount("distributorSheet");
		for (int i = 1; i <= rowCount; i++) { // skip row 0 (header)
			String DistName = eu.getDataFromExcel("distributorSheet", i, 0) + ju.getRandomNumber();
			String phoneNo = eu.getDataFromExcel("distributorSheet", i, 1) + ju.getRandomNumber();
			
			Add_DistributorPage ad = new Add_DistributorPage(driver);
			ad.addDistributors(phoneNo, DistName);
		}
		Thread.sleep(500); // or better: use wait for form to close
**/
	}

}
