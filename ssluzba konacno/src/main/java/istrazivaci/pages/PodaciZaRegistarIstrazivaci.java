package istrazivaci.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import helpers.Utils;
public class PodaciZaRegistarIstrazivaci {

	private WebDriver driver;

	public PodaciZaRegistarIstrazivaci(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement tabPodaciZaRegistar() {
		return Utils.waitForElementPresence(driver, By.xpath(".//li[2]// tab-heading"), 10);
	}
	
	
	
	public WebElement getBibliografija() {
		return Utils.waitForElementPresence(driver, By.name("bibliography"), 10);
		
	}
	public void setBibliografija(String bibliografija) {
		WebElement input = getNapomena();
		input.clear();
		input.sendKeys(bibliografija);
	}
	public WebElement bibliografijaRquiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti bibliografiju.')]"), 10);
	}
	
	
	
	
	
	public WebElement getOblastIstrazivanja() {
		return Utils.waitForElementPresence(driver, By.name("researchAreas"), 10);
		
	}
	public void setOblastIstrazivanja(String oblastistrazivanja) {
		WebElement input = getNapomena();
		input.clear();
		input.sendKeys(oblastistrazivanja);
	}
	public WebElement oblastIstrazivanjaRquiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Unesite oblasti istrazivanja.')]"), 10);
	}
	
	
	
	
	
	
	public WebElement getIDBrojUMinistarstvu() {
		return Utils.waitForElementPresence(driver, By.name("mntrn"), 10);

	}
	public void setIDBrojUMinistarstvu(String IDBroj) {
		WebElement input = getNapomena();
		input.clear();
		input.sendKeys(IDBroj);
	}
	public WebElement IDBrojRquiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti identifikacioni broj u ministarstvu.')]"), 10);
	}
	
	
	
	
	
	

	public WebElement getNapomena() {
		return Utils.waitForElementPresence(driver, By.name("note"), 10);

	}
	public void setNapomena(String napomena) {
		WebElement input = getNapomena();
		input.clear();
		input.sendKeys(napomena);
	}
	
	


	public WebElement getButtonSave() {
		return Utils.waitForElementPresence(driver, By.xpath(".//button[@ng-click='addctrl.savePerson(Register)']"), 10);
	}
	public WebElement getButtonOdustani() {
		return Utils.waitForElementPresence(driver, By.xpath(".//button[@ng-click='reset()']"), 10);
	}
	
	
	
	
	public void unosPodatakaZaRegistar(String bibliografija, String oblastistrazivanja,String IDBroj,String napomena){
		setBibliografija(bibliografija);
		setOblastIstrazivanja(oblastistrazivanja);
		setIDBrojUMinistarstvu(IDBroj);
		setNapomena(napomena);
		getButtonSave().click();
		
	}
	
	
	
	
	
}
