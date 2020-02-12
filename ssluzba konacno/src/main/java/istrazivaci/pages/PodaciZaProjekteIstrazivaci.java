package istrazivaci.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helpers.Utils;

public class PodaciZaProjekteIstrazivaci {
	private WebDriver driver;

	public PodaciZaProjekteIstrazivaci(WebDriver driver) {
		super();
		this.driver = driver;
	}
	

	public WebElement tabPodaciZaProjekte() {
		return Utils.waitForElementPresence(driver, By.xpath(".//li[3]//tab-heading"), 10);
	}
	
	public Select getTipOsobe() {
		return new Select(Utils.waitForElementPresence(driver, By.xpath(".//select[@name='personType']"), 10));
	}
	public void setTipOsobe(String tip) {
		this.getTipOsobe().selectByVisibleText(tip);
	}
	public WebElement tipOsobeRquiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate izabrati tip istraživača.')]"), 10);
	}
	

	
	
	
	
	
	public Select getObracunskoZvanje() {
		return new Select(Utils.waitForElementPresence(driver, By.xpath(".//select[@name='personPosition']"), 10));
	}

	public void setObracunskoZvanje(String value) {
		this.getObracunskoZvanje().selectByVisibleText(value);
	}
	


	
	
	
	public WebElement getKategorijaIstrazivaca() {   
		return Utils.waitForElementPresence(driver, By.xpath(".//div[@title='Kategorije istraživača']//input"), 10);
	}
	public void setKategorijaIstrazivaca(String kategorija) {
		WebElement input = getKategorijaIstrazivaca();
		input.clear();
		input.sendKeys(kategorija);
	}
		
		
		
		
		
		
		
	public WebElement getButtonSave() {
		return Utils.waitForElementPresence(driver, By.xpath(".//button[@ng-click='addctrl.savePerson(Project)']"), 10);
	}
		
	public WebElement getButtonCancel() {
		return Utils.waitForElementPresence(driver, By.xpath(".//button[@ng-click='reset()']"),10);
	}
		
	public void unosPodatakaZaProjekte(String tip, String value,String kategorija){
		setTipOsobe(tip);
		setObracunskoZvanje(value);
		setKategorijaIstrazivaca(kategorija);
		getButtonSave().click();
		
	}
	
	
	
	
}
