package EndToEndTest;

import org.testng.annotations.Test;
import BaseClass.BaseTest;
import FileUtility.ExcelUtility;
import ObjectRepository.Add_DistributorPage;
import ObjectRepository.HomePage;
import ObjectRepository.InventoryPage;
import ObjectRepository.PurchaseReport_Page;
import ObjectRepository.Purchases_page;
import ObjectRepository.Reports_Page;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class DistE2E extends BaseTest {
	WebDriverUtility wu = new WebDriverUtility();
	JavaUtility ju = new JavaUtility();
	ExcelUtility eu = new ExcelUtility();

	@Test
	public void addDistributors() throws Throwable {

		wu.waitForPageLoad(driver);

		// Step 1: Login to app

		// Step 2 : Navigate to inventory module and click on add products
		HomePage hp = new HomePage(driver);
		hp.clickOpenMenu();
		hp.clickDistributor();

		// Step 3: Read data from excel file and create a bill
		String baseDistName = eu.getDataFromExcel("distributorSheet", 2, 0);
		String basePhone = eu.getDataFromExcel("distributorSheet", 2, 1) + ju.getRandomNumber();
		String baseProductName = eu.getDataFromExcel("productSheet", 1, 0);

		System.out.println("Adding Distributor:");
		System.out.println("Name: " + baseDistName);
		System.out.println("Phone: " + basePhone);

		// Step 4: Add distributor
		Add_DistributorPage ad = new Add_DistributorPage(driver);
		ad.addDistributors(basePhone, baseDistName);

		// Optional delay
		Thread.sleep(500);

		// Step 5: Open Menu and click on inventory and click on purchases
		hp.clickOpenMenu();

		hp.clickInventory();
		Thread.sleep(500);
		InventoryPage ip = new InventoryPage(driver);
		Thread.sleep(1000);
		ip.clickOnPurchases();

		// Step 6: Make a purchase from the distributor that you have added
		Purchases_page pp = new Purchases_page(driver);
		pp.addDist(baseDistName, baseProductName);

		// Step 7 : click on open menu and go to purchase report
		hp.clickOpenMenu();
		hp.clickReports();
		Reports_Page rp = new Reports_Page(driver);
		rp.purchases().click();

		PurchaseReport_Page pr = new PurchaseReport_Page(driver);
		pr.getPurchaseReport().click();
		pr.getPreviewBtn().click();

	}

}
