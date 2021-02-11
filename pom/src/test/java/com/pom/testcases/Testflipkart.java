package com.pom.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pom.base.Testbaseflipkart;
import com.pom.pages.Flipkart_home_page;
import com.pom.pages.Samsun_page;
import com.pom.utilities.Action_utilities;
import com.pom.utilities.Test_utilities;

public class Testflipkart extends Testbaseflipkart {
	Flipkart_home_page flipkart_homepage;
	Samsun_page samsung_page;
	 Action_utilities action_perform;
	 
	  public Testflipkart() {
		super();
	}

	@BeforeTest
	@Parameters({"browser","url"})
	public void starttest(String browserName,String Urlname) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.get(Urlname);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Test_utilities.implict_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Test_utilities.page_load_timeout, TimeUnit.SECONDS);
	}

	@Test
	public void testcase() throws InterruptedException {
		// inilitiliaze flipkart homepage
		flipkart_homepage = new Flipkart_home_page();
		action_perform =new Action_utilities();
		// initililiaze samsung page
		samsung_page = new Samsun_page();
		//to perform escape action
		action_perform.perform_escape_action();
		// click on all offers button
		flipkart_homepage.click_on_alloffers_button();
		Thread.sleep(2000);
		action_perform.perform_move_to_element(flipkart_homepage.drop_down_electronics());
		// Validate with the text samsung
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(flipkart_homepage.To_check_The_presenttext)));
		// move to element samsung and click on it
		action_perform.perform_move_to_element_and_click(flipkart_homepage.text_to_validate());
		Thread.sleep(3000);
		// navigate to the samsung page and get the title of the page.
		String page_title = samsung_page.To_get_title();
		// Verify with the title of the page
		Assert.assertTrue(page_title.contains("Samsung"));
		Reporter.log("testcase1 Passed");

	}

	@AfterTest
	public void logout() {
		driver.close();
	}
}
