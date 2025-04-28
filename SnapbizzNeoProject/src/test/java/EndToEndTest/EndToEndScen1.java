package EndToEndTest;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.BaseTest;
import FileUtility.ExcelUtility;
import ObjectRepository.Add_CustomerPage;
import ObjectRepository.BillingCartPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class EndToEndScen1 extends BaseTest{
	
	WebDriverUtility wu= new WebDriverUtility();
    JavaUtility ju= new JavaUtility();
	ExcelUtility eu= new ExcelUtility();
	
	
	@Test(priority = 1)
	public void loginToApp() throws Throwable, Throwable {
		//Login to app
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp();
		//System.out.println(" Logged in successfully ");
	}
	
	@Test(priority = 2)
	public void addCustomers() throws Throwable {
		
	  	wu.waitForPageLoad(driver);
	  	
		
		//Navigate to inventory module and click on add products
		HomePage hp= new HomePage(driver);
		hp.clickOpenMenu();
		hp.clickCustomer();

	    String custName = eu.getDataFromExcel("customerSheet", 1, 0) + ju.getRandomNumber();
        String custPhone = eu.getDataFromExcel("customerSheet", 1, 1) + ju.getRandomNumber();

        Add_CustomerPage ac = new Add_CustomerPage(driver);
        ac.createCustumer(custPhone, custName);
        ac.getCancelBtn();
	   }
	
	@Test(priority = 3)
	public void cartBilling() throws Throwable, IOException {
		HomePage hp= new HomePage(driver);
		hp.clickOpenMenu();
		hp.clickCart();
		
        String productName = eu.getDataFromExcel("productSheet", 1, 0) ;
        String custName = eu.getDataFromExcel("customerSheet", 1, 0);

        
		BillingCartPage bp=new BillingCartPage(driver);
		bp.cartBilling(productName, custName);
	}
	
	
}
