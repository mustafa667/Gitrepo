package com.pom.pages;

import org.openqa.selenium.support.PageFactory;

import com.pom.base.Testbaseflipkart;

public class Samsun_page extends Testbaseflipkart {
	
	public Samsun_page()
	{
		PageFactory.initElements(driver, this);
	}
	//Validate title of the samsung page
	public String To_get_title()
	{
		return driver.getTitle();
		
	}

}
