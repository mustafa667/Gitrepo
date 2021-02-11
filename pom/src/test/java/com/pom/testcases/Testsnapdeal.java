package com.pom.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pom.base.Testbase;
import com.pom.pages.Snapdeal_Home_page;
import com.pom.pages.Snapdeal_Product_page;
import com.pom.utilities.Excel_utility;
import com.pom.utilities.ExtentReportdemo;
import com.pom.utilities.Test_utilities;


public class Testsnapdeal extends Testbase {
	
	Snapdeal_Home_page snapdeal_home;
	Snapdeal_Product_page snapdeal_product;
	//ExtentReports extent;

	

	@BeforeTest
	@Parameters({"browser","url"})
	public void launch(String browserName, String urlname) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.get(urlname);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Test_utilities.implict_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Test_utilities.page_load_timeout, TimeUnit.SECONDS);
		
		/*String reports=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(reports);
		reporter.config().setReportName("Web automation results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent= new  ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","mustafa");*/
		
	}
@DataProvider
public Object[][] get_product_data() {
	Object data[][]=Excel_utility.getTestdata("Test");
	return data;
	
	
}
	@Test(dataProvider="get_product_data")
	public void testcase1(String product_to_search) throws InterruptedException {
		
		try {
			//extent.createTest("testcase1");
			snapdeal_home = new Snapdeal_Home_page();
			snapdeal_product = new Snapdeal_Product_page();
			
			
			// To enter Mobiles in search field
			snapdeal_home.search_product(product_to_search);
			// To hit on the enter button
			snapdeal_home.HitEnter();
			// to clear the text in the from field
			snapdeal_home.clear_Minimum_productprice();
			// to enter the text as 40 in the field
			snapdeal_home.Enter_Minimum_productprice("40");
			// to clear the text in to field
			snapdeal_home.clear_maximum_price();
			// to enter the value in to field
			snapdeal_home.Enter_maximum_price("100");
			// click on go button
			snapdeal_home.Click_on_go();
			// collection of value into the list
			Thread.sleep(3000);
			List<WebElement> list_of_product_prices = driver
					.findElements(By.xpath("//span[@class='lfloat product-price']"));
			int list_of_product_size = list_of_product_prices.size();
			for (int i = 0; i < list_of_product_size; i++) {
				// String Allvalues = list_of_value.get(1).getText();
				list_of_product_prices.get(1).click();
				driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
				ArrayList<String> Windows_ids = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(Windows_ids.get(1));
				WebDriverWait wait = new WebDriverWait(driver, 20);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", snapdeal_product.cart_button());
				Thread.sleep(2000);
				wait.until(ExpectedConditions.stalenessOf(snapdeal_product.cart_button()));
				String successfull_text = snapdeal_product.successfull_text();
				String successful_message = "added to your cart";
				Assert.assertTrue(successfull_text.contains(successful_message));
				Reporter.log("Testcase2 Passed");
			//	extent.flush();
				

			}
		} catch (Exception exception) {
			System.out.println(exception.toString());
		}

	}

	@AfterTest
	public void tear_down() {
		driver.quit();
	}

}
