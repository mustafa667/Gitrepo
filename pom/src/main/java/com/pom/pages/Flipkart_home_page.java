package com.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.Testbaseflipkart;

public class Flipkart_home_page extends  Testbaseflipkart{
	public String To_check_The_presenttext = "Samsung";
	
	
	public Flipkart_home_page()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='_1mkliO'][1]/div/img")
	WebElement alloffersbutton;
	
	@FindBy(xpath="//div[@class='_1kidPb']/span[contains(text(),'Electronics')]")
	WebElement electronics_dropdown;
	@FindBy(linkText="Samsung")
	WebElement Text_to_be_present;
	
	public void click_on_alloffers_button()
	{
		alloffersbutton.click();
	}
	public WebElement drop_down_electronics()
	{
		return electronics_dropdown;
	}
	public WebElement text_to_validate()
	{
		return Text_to_be_present;
		
	}

}
