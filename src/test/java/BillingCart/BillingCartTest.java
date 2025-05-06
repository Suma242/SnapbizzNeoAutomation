package BillingCart;
import org.testng.annotations.Test;

import BaseClass.BaseTest;
import BaseClass.BaseTst;
import FileUtility.ExcelUtility;
import ObjectRepository.BillingCartPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPageOld;
import ObjectRepository.Reports_Page;
import ObjectRepository.SalesReports_Page;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class BillingCartTest extends BaseTest{
	WebDriverUtility wu= new WebDriverUtility();
    JavaUtility ju= new JavaUtility();
	ExcelUtility eu= new ExcelUtility();



		
	@Test
	public void billingCart() throws Throwable {
	
  	wu.waitForPageLoad(driver);
  	
    //Step 1: Login to app
	
	//Step 2: Navigate to billing cart module 
	HomePage hp= new HomePage(driver);
	hp.clickOpenMenu();
	hp.clickCart();
	
	//Step 3: Read data from excel file and create a bill
    String productName = eu.getDataFromExcel("productSheet", 1, 0);
    String custName = eu.getDataFromExcel("customerSheet", 1, 0);

    
	BillingCartPage bp = new BillingCartPage(driver);
	bp.cartBilling(productName, custName);	
	
	hp.clickOpenMenu();
	hp.clickBills();
	Thread.sleep(1000);
	hp.clickOpenMenu();
	hp.clickReports();
	
	Reports_Page rp= new Reports_Page(driver);
	rp.sales().click();
	
	SalesReports_Page sp= new SalesReports_Page(driver);
	sp.getSalesRegisterReport().click();
	sp.getPreviewBtn().click();
	}
}
