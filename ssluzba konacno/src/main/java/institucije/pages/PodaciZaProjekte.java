package institucije.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helpers.Utils;

public class PodaciZaProjekte {

	private WebDriver driver;

	public PodaciZaProjekte(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement tabPodaciZaProjekte() {
		return Utils.waitToBeClickable(driver, By.xpath(".//ul/li[3]//tab-heading"), 10);
	}

	
	
	public WebElement getRacun() {
		return Utils.waitForElementPresence(driver, By.name("account"), 10);

	}
	public void setRacun(String racun) {
		WebElement input = getRacun();
		input.clear();
		input.sendKeys(racun);
	}

	public WebElement racunRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti broj računa.')]"), 10);
	}
	public WebElement racunFormatError() {
		return Utils.waitForElementPresence(driver,By.xpath("//span[contains (text(),'Broj računa mora biti u formatu XXX-XXXXXXXXXXXXX-XX.')]"), 10);
	}
	
	
	
	
	public WebElement getIDUMinistarstvu() {
		return Utils.waitForElementPresence(driver, By.name("mntrID"), 10);
		
	}

	
	
	
	public WebElement getIDMedjunarodniNivo() {
		return Utils.waitForElementPresence(driver, By.name("orcid"), 10);
	}

	public void setIDMedjunarodniNivo(String idmedjunarodni) {
		WebElement input = getIDMedjunarodniNivo();
		input.clear();
		input.sendKeys(idmedjunarodni);
	}

	
	
	//sve za status institucije 
	
	public void setStatusInstitucije(String status) {
		Select sl =new Select(Utils.waitForElementPresence(driver, By.name("institutionStatus"), 10));
		sl.selectByVisibleText(status);
		
	}

	public WebElement statusInstitucijeRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate izabrati status institucije.')]"), 10);
	}
	
	
	
	
	
	
	
	
	
	public WebElement getOblastIstrazivanja() {
		return Utils.waitForElementPresence(driver, By.id("s2id_autogen6"), 10);
		
	}

	
	
	
	
	
	
	public WebElement getButtonCancel() {
		return Utils.waitToBeClickable(driver, By.xpath(".//button[@ng-click='reset(Project)']"), 10);
	}

	
	public WebElement getButtonSave() {
		return Utils.waitToBeClickable(driver, By.xpath(".//button[@ng-click='addctrl.saveInstitution(Project)']"), 10);
	}
	
	
	
	
	
		public void unosPodataka(String racun, String idmedjunarodni,String status){
			setRacun(racun);
			setIDMedjunarodniNivo(idmedjunarodni);
			setStatusInstitucije(status);
			getButtonSave().click();
			
		}
	
}
