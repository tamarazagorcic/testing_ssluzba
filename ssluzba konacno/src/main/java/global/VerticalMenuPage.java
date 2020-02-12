package global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.Utils;

public class VerticalMenuPage {
	private WebDriver driver;

	public VerticalMenuPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public WebElement getInstitucijaButton() {
		return Utils.waitForElementPresence(driver, By.xpath("//a [@href='#/admin-institution/']"), 10);
	}


	public WebElement getIstrazivaciButton() {
		return Utils.waitForElementPresence(driver, By.xpath("//a [@href='#/persons']"), 10);
	}
	
	
	
	
}
