package istrazivaci.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.Utils;

public class AngazovanjeTab {

	private WebDriver driver;

	public AngazovanjeTab(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	public WebElement getButtonAngazujOsobu() {
		return Utils.waitForElementPresence(driver, By.xpath("//button [@ng-click='addctrl.addConnection()']"), 10);
	}

	
	
	public WebElement tabAngazovanja() {
		return Utils.waitForElementPresence(driver, By.xpath(".//li[4]//tab-heading"), 10);
	}
	
	
	
	public WebElement getProcenat() {
		return Utils.waitForElementPresence(driver,  By.name("employmentPercentage"), 10);

	}

	public void setProcenat(String procenat) {
		WebElement input = getProcenat();
		input.clear();
		input.sendKeys(procenat);
	}
	
	
	public WebElement getDatumPocetkaAngazovanja() {
		return Utils.waitForElementPresence(driver, By.name(".//em-date-time-picker[@name='startDate']//input"), 10);
	}
	public void setDatumPocetkaAngazovanja(String datum) {
		WebElement input = getDatumPocetkaAngazovanja();
		input.clear();
		input.sendKeys(datum);

	}
	public WebElement datumPocetkaError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Unesite datum angažovanja.')]"), 10);
	}
	
	public WebElement getButtonSave() {
		return Utils.waitToBeClickable(driver, By.xpath(".//button[@ng-click='addctrl.savePersonConnection(Persons)']"), 10);
	}

	public WebElement getButtonCancel() {
		return Utils.waitToBeClickable(driver, By.xpath(".//button[@ng-click='addctrl.cancel(Persons)']"), 10);
	}
	

}
