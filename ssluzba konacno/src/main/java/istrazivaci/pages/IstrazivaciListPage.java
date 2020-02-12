package istrazivaci.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.Utils;

public class IstrazivaciListPage {
	private WebDriver driver;

	public IstrazivaciListPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getPretragaIstrazivaca() {
		return Utils.waitForElementPresence(driver, By.xpath(".//input[@placeholder='Pretraži istraživače']"), 10);
	}
	public void setPretragaIstrazivaca(String pretraga) {
		WebElement input = getPretragaIstrazivaca();
		input.clear();
		input.sendKeys(pretraga);
	}
	public WebElement pretragaError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Search query is too short')]"), 10);
	}
	
	public WebElement getrezultatPretrage1() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[@ng-click='selectMatch($index)']/a"), 10);
	}
	public WebElement getRezultatDropdown() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul [@ng-show='isOpen() && !moveInProgress']"), 10);
	}
	public WebElement getRezultatPretrage(String value) {
		return this.getRezultatDropdown().findElement(By.xpath("./li/a[contains(text(),\""+value+"\")]"));
	}
	

	public WebElement getIstrazivaciTable() {
		return Utils.waitForElementPresence(driver, By.xpath("//table"), 10);
	}

	public List<WebElement> getTableRows() {
		return this.getIstrazivaciTable().findElements(By.tagName("tr"));
	}
	
	public boolean isIstrazivacInTabela(String ime, String prezime) {
		return Utils.isPresent(driver, By.xpath("//tr[contains(td[1],\"" + ime + "\")][contains(td[2],\"" + prezime + "\")]"));
	}

	public WebElement getIstrazivacByImeIPrezime(String ime, String prezime) {
		return Utils.waitForElementPresence(driver, By.xpath("//tr[contains(td[1],\"" + ime + "\")][contains(td[2],\"" + prezime + "\")]"), 15);
	}
	
	public WebElement getMigriraniPodaci() {
		return Utils.waitToBeClickable(driver, By.name("migrated"), 10);
	}
	
	public WebElement getVerifikovaniMigriraniPodaci() {
		return Utils.waitToBeClickable(driver, By.name("changed"), 10);
	}
	
	public WebElement getTableIme() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Ime')]"), 10);
	}
	public WebElement getTablePrezime() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Prezime')]"), 10);
	}
	public WebElement getTableDatumRodjenja() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Datum rođenja')]"), 10);
	}



	

}
