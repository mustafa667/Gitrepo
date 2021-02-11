package com.pom.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.Testbase;

public class Snapdeal_Home_page extends Testbase {
	
	 public Snapdeal_Home_page() 
	 {
		PageFactory.initElements(driver, this);
	}
	// Search field
	@FindBy(id = "inputValEnter")
	WebElement searchbox;
	// To enter minimum value in product text field
	@FindBy(name = "fromVal")
	WebElement from_productvalue;
	// To enter maximum value in product p
	@FindBy(name = "toVal")
	WebElement to_productvalue;
	// click on go
	@FindBy(xpath = "//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")
	WebElement gobutton;
	

	// to search in search field
	public void search_product(String user) {
		this.searchbox.sendKeys(user);
	}

	// to hit the enter button on keyboard
	public void HitEnter() {
		this.searchbox.sendKeys(Keys.ENTER);
	}

	// to clear the minimum value in from text field
	public void clear_Minimum_productprice() {
		this.from_productvalue.clear();
	}

	// to Enter the value in from text  field
	public void Enter_Minimum_productprice(String value) {
		this.from_productvalue.sendKeys(value);
	}

	// to clear the text field of maximum product price
	public void clear_maximum_price() {
		this.to_productvalue.clear();
	}

	// to enter the maximum product price into the text field
	public void Enter_maximum_price(String value) {
		this.to_productvalue.sendKeys(value);
	}

	// to click on go button
	public void Click_on_go() {
		this.gobutton.click();
	}

	

}
