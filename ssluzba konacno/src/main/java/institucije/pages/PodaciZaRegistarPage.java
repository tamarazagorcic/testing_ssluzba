package institucije.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helpers.Utils;


 
public class PodaciZaRegistarPage {
	private WebDriver driver;

	public PodaciZaRegistarPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	
	public WebElement tabPodaciZaRegistar() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul/li[2]//tab-heading"), 10);
	}
	public WebElement pocetnaProveraZaRegistar() {
		return Utils.waitForElementPresence(driver, By.xpath("//div [@ng-repeat,'tab in tabs')]"), 10);
	}
	
	
	//sve za pib
	
	public WebElement getPib() {
		return Utils.waitForElementPresence(driver, By.xpath("//input [@name='pib']"), 10);
	}

	public void setPib(String pib) {
		WebElement input = getPib();
		input.clear();
		input.sendKeys(pib);
	}


	public WebElement pibRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti PIB.')]"), 10);
	}
	public WebElement pibFormatError() {
		return Utils.waitForElementPresence(driver,By.xpath("//span[contains (text(),'Poreski broj nije u dobrom formatu.')]"), 10);
	}
	
	
	
	//sve za MB
	
	
	public WebElement getMaticniBroj() {
		return Utils.waitForElementPresence(driver, By.xpath("// input[@name='maticniBroj']"), 10);

	}

	public void setMaticniBroj(String maticnibroj) {
		WebElement input = getMaticniBroj();
		input.clear();
		input.sendKeys(maticnibroj);
	}

	public WebElement maticniBrojRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Unesite matični broj.')]"), 10);
	}
	public WebElement maticniBrojFormatError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Matični broj se mora sastojati od 13 cifara')]"), 10);
	}
	
	
	
	
	//sve za akreditaciju
	
	public WebElement getbrojAkreditacije() {
		return Utils.waitForElementPresence(driver, By.name("accreditationNumber"), 10);
	}

	public void setbrojAkreditacije(String brojAkreditacije) {
		WebElement input = getbrojAkreditacije();
		input.clear();
		input.sendKeys(brojAkreditacije);
	}
	
		public WebElement akreditacijaBrojRequiredError() {
			return Utils.waitForElementPresence(driver,By.xpath("//span[contains (text(),'Morate uneti broj akreditacije.')]"), 10);
		}
	
	
	
	//sve za datum akreditacije
		
	public WebElement getDatumAkreditacije() {
		return Utils.waitForElementPresence(driver, By.xpath("(.// input[@ng-model='data.date'])[1]"), 10);

	}

	public void setDatumAkreditacije(String datum) {
		WebElement input = getDatumAkreditacije();
		input.clear();
		input.sendKeys(datum);
	}

	public WebElement akreditacijaDatumRequiredError() {
		return Utils.waitForElementPresence(driver,By.xpath("//span[contains (text(),'Unesite datum akreditacije!')]"), 10);
	}
	
	
	
	//sve za instituciju
	
	public WebElement getNazivInstIzAkreditacije() {
		return Utils.waitForElementPresence(driver, By.name("accreditationNote"), 10);

	}

	public void setNazivInstitucijeAkreditacije(String naziv) {
		WebElement input = getNazivInstIzAkreditacije();
		input.clear();
		input.sendKeys(naziv);
	}
	public WebElement nazivInstitucijeRequiredError() {
		return Utils.waitForElementPresence(driver,By.xpath("//span[contains (text(),'Morate uneti naziv institucije iz akreditacije.')]"), 10);
	}
	
	
	//sve za napomenu
	
	public WebElement getNapomenaoRegistru() {
		return Utils.waitForElementPresence(driver, By.xpath("// input[@name='note']"), 10);
	}

	public void setNapomenaoRegistru(String napomena) {
		WebElement input = getNapomenaoRegistru();
		input.clear();
		input.sendKeys(napomena);
	}

	
	
	//sve za vrstu institucije
	
	public void setVrstaInstitucije(String vrstaInstitucije) {
		Select sl = new Select(Utils.waitForElementPresence(driver, By.name("institutionType"), 10));
		sl.selectByVisibleText(vrstaInstitucije);;
	}
	
	
	public WebElement vrstaInstitucijeRequiredError() {
		return Utils.waitForElementPresence(driver,By.xpath(".//span[contains (text(),'Morate izabrati vrstu institucije.')]"), 10);
	}


	
	
	
	//sve za osnivaca
	
	public WebElement getOsnivac() {
		return Utils.waitForElementPresence(driver, By.name("founder"), 10);
	}

	public void setOsnivac(String osnivac) {
		WebElement input = getOsnivac();
		input.clear();
		input.sendKeys(osnivac);
	}

	
	
	//sve za datum osnivanja
	
	public WebElement getDatumOsnivanja() {
		return Utils.waitForElementPresence(driver, By.xpath("(.// input[@ng-model='data.date'])[2]"), 10);
	}

	public void setDatumOsnivanja(String datumOsnivanja) {
		WebElement input = getDatumOsnivanja();
		input.clear();
		input.sendKeys(datumOsnivanja);
	}
	
	
	
	
	//sve o resenju o osnivanju
	
	public WebElement getBrojResenjaOOsnivanju() {
		return Utils.waitForElementPresence(driver, By.name("rescriptNumber"), 10);

	}

	public void setResenjeOosnivanju(String brresenja) {
		WebElement input = getBrojResenjaOOsnivanju();
		input.clear();
		input.sendKeys(brresenja);
	}
	
	
	
	
	
	// izbor vlasnicke strukture  
	
	public String getVlasnickaStruktura() {
		return Utils.waitForElementPresence(driver, By.xpath(".// select[@name='ownershipStructure']"), 10).getText();
	}

	public void setVlasnickaStruktura(String value) {
		Select sl = new Select(Utils.waitForElementPresence(driver,By.xpath(".// select[@name='ownershipStructure']"),10));
		sl.selectByVisibleText(value);
	}

	
	
	
	// dugme za odustajanje
	public WebElement getButtonCancel() {
		return Utils.waitToBeClickable(driver, By.xpath(".//button[@ng-click='reset(Register)']"), 10);
	}

	// dugme za snimanje
	public WebElement getButtonSave() {
		return Utils.waitToBeClickable(driver, By.xpath(".//button[@ng-click='addctrl.saveInstitution(Register)']"),10);
	}

	


	public void unosPodatakaZaRegistar(String pib,String maticnibroj, String brojAkreditacije,String datum,String nazivInstitucije,
			String napomena,String vrstaInstitucije, String osnivac,String datumOsnivanja,String brresenja,String value){
		setPib(pib);
		setMaticniBroj(maticnibroj);
		setbrojAkreditacije(brojAkreditacije);
		setDatumAkreditacije(datum);
		setNazivInstitucijeAkreditacije(nazivInstitucije);
		setNapomenaoRegistru(napomena);
		setVrstaInstitucije(vrstaInstitucije);
		setOsnivac(osnivac);
		setDatumOsnivanja(datumOsnivanja);
		setResenjeOosnivanju(brresenja);
		setVlasnickaStruktura(value);
		getButtonSave().click();
		
	}
	
//	//osnovna delatnost institucije
//	public void setOsnovnaDelatnostInstitucije(String delatnostInstitucije) {
//		Select sl = new Select(Utils.waitForElementPresence(driver, By.id("s2id_autogen4"), 10));
//		sl.selectByVisibleText(delatnostInstitucije);;
//	} 


}
