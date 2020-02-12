package istrazivaci.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helpers.Utils;

public class AngazovanjeIstrazivaca {

	private WebDriver driver;

	public AngazovanjeIstrazivaca(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getModalDialog() {
		return Utils.waitForElementPresence(driver, By.className("modal-dialog"), 10);
	}


	public WebElement getAngazovanjeProzor() {
		return Utils.waitForElementPresence(driver, By.name("personFrom"), 10);
	}
	
	public void setZvanjeIstrazivaca(String zvanje) {
		Select status = new Select(Utils.waitForElementPresence(driver, By.xpath(".//select[@ng-model='connection.position']"), 10));
		status.selectByVisibleText(zvanje);
	}

	public WebElement getFunkcijaIstrazivaca() {
		return Utils.waitForElementPresence(driver, By.xpath(".//select[@ng-model='connection.function']"), 10);
	}
	
	

	public void setFunkcijaIstrazivaca(String funkcija) {
		Select status = new Select(Utils.waitForElementPresence(driver, By.xpath("//select[@ng-model='connection.function']"), 10));
		status.selectByVisibleText(funkcija);
	}
	

	public WebElement getDatumPocetkaAngazovanja() {
		return Utils.waitForElementPresence(driver, By.xpath("//em-date-time-picker[@name='startDate']//input"), 10);
	}
	public void setDatumPocetkaAngazovanja(String datum) {
		WebElement input = getDatumPocetkaAngazovanja();
		input.clear();
		input.sendKeys(datum);

	}
	public WebElement datumPocetkaError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Unesite datum angažovanja.')]"), 10);
	}

	
	
	
	
	public WebElement getDatumPrestankaAngazovanja() {
		return Utils.waitForElementPresence(driver, By.xpath("//em-date-time-picker[@name='endDate']//input"), 10);
	}
	public void setDatumPrestankaAngazovanja(String datumkraj) {
		WebElement input = getDatumPrestankaAngazovanja();
		input.clear();
		input.sendKeys(datumkraj);

	}
	

	public WebElement getButtonSave() {
		return Utils.waitToBeClickable(driver, By.xpath(".//button[@ng-click='save()']"), 10);
	}

	public WebElement getButtonCancel() {
		return Utils.waitToBeClickable(driver, By.xpath(".//button[@ng-click='cancel()']"), 10);
	}
	
	public void unosIstrazivaca(String zvanje, String funkcija, String datum,String datumkraj){
		
		
		
		setZvanjeIstrazivaca(zvanje);
		setFunkcijaIstrazivaca(funkcija);
		setDatumPocetkaAngazovanja(datum);
		setDatumPrestankaAngazovanja(datumkraj);
		
		getButtonSave().click();
		 
		}

	
	
	
	
}
