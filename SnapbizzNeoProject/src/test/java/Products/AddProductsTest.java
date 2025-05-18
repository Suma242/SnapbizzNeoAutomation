package Products;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseTest;
import FileUtility.ExcelUtility;
import ObjectRepository.AddProduct_Page;
import ObjectRepository.HomePage;
import ObjectRepository.InventoryPage;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;


//@Listeners(ListenerUtility.ListenerImpClass.class)
public class AddProductsTest extends BaseTest {
	
	WebDriverUtility wu= new WebDriverUtility();
    JavaUtility ju= new JavaUtility();
	ExcelUtility eu= new ExcelUtility();
	
	@Test
	public void addProducts() throws InterruptedException, Throwable, IOException {
	    
	  	wu.waitForPageLoad(driver);
	  	
		//Step 1: Login to application
	  	
		//Step 2:Navigate to inventory module and click on add products
	  	
		HomePage hp= new HomePage(driver);
		hp.clickOpenMenu();
		hp.clickInventory();
		
		InventoryPage inventory= new InventoryPage(driver);
		inventory.clickAddProducts();
		
		//Step 3: read data from excel and click on AddProduct
	    int rowCount = eu.getRowCount("productSheet");
	    for (int i = 1; i <= rowCount; i++) {     
				String barcode=eu.getDataFromExcel("productSheet", i, 0)+ju.getRandomNumber();
				String productName=eu.getDataFromExcel("productSheet", i, 1)+ ju.getRandomNumber();
				String purchaseprice=eu.getDataFromExcel("productSheet", i, 2);
				String mrp=eu.getDataFromExcel("productSheet", i, 3);
				String uom=eu.getDataFromExcel("productSheet", i, 4);
				
				AddProduct_Page ap= new AddProduct_Page(driver);
				ap.createProducts(barcode, productName, purchaseprice, mrp, uom);
	    }				
	}
}
