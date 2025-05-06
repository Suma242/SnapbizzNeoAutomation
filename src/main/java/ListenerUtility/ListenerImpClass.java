package ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerImpClass implements ITestListener, ISuiteListener{
	WebDriver driver = null;
	public void onStart(ISuite suite) {
		ISuiteListener.super.onStart(suite);
	}

	public void onFinish(ISuite suite) {
		ISuiteListener.super.onFinish(suite);
	}

	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
	}

	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
	}

	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./SnapbizzNeoProject/Screenshot/ss.png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/** TakesScreenshot ts = (TakesScreenshot) driver;
		    File src = ts.getScreenshotAs(OutputType.FILE);
		    
		    // Use method name + timestamp to avoid overwriting
		    String methodName = result.getMethod().getMethodName();
		    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		    File dest = new File("./SnapbizzNeoProject/Screenshot/" + methodName + "_" + timestamp + ".png");

		    try {
		        FileHandler.copy(src, dest);
		        System.out.println("Screenshot saved: " + dest.getAbsolutePath());
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		
		
		Object testInstance = result.getInstance();  // Get the test instance

	    try {
	        // Access 'driver' field from the test class
	        driver = (WebDriver) testInstance.getClass().getDeclaredField("driver").get(testInstance);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    if (driver != null) {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File src = ts.getScreenshotAs(OutputType.FILE);
	        
	        String methodName = result.getMethod().getMethodName();
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        File dest = new File("./SnapbizzNeoProject/Screenshot/" + methodName + "_" + timestamp + ".png");

	        try {
	            dest.getParentFile().mkdirs();  // Ensure directory exists
	            FileHandler.copy(src, dest);
	            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("Driver is null. Screenshot not taken.");
	    }
		**/
		

	}
		

	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		System.out.println("====SKIPPED====");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}

	
	
}
