package com.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.Testbase;

public class Snapdeal_Product_page extends Testbase {

	public Snapdeal_Product_page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "add-cart-button-id")
	WebElement add_to_cart;
	@FindBy(xpath = "//span[@class='mess-text']")
	WebElement Successtext_adding_to_cart;

	public WebElement cart_button() {
		return add_to_cart;
	}

	public String successfull_text() {
		return Successtext_adding_to_cart.getText();
	}

}
