package com.pom.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pom.base.Testbaseflipkart;

public class Action_utilities extends Testbaseflipkart {
	
	
	Actions actions=new Actions(driver);
	
	public void perform_escape_action()
	{
		actions.sendKeys(Keys.ESCAPE).perform();
	}
	public void perform_move_to_element(WebElement element)
	{
		actions.moveToElement(element).perform();
	}
	public void perform_move_to_element_and_click (WebElement element)
	{
		actions.moveToElement(element).click().perform();
	}

}
