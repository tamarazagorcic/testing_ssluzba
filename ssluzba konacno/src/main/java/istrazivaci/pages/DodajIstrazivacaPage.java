package istrazivaci.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helpers.Utils;

public class DodajIstrazivacaPage {
	private WebDriver driver;

	public DodajIstrazivacaPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	

	public WebElement getButtonDodajIstarzivaca() {
		return Utils.waitForElementPresence(driver, By.xpath("//a [@ui-sref='addPerson']"), 10);
	}

	
	
	public WebElement tabLicniPodaci() {
		return Utils.waitForElementPresence(driver, By.xpath(".//li[1]//tab-heading"), 10);
	}

	
	
	
	
	public WebElement getIme() {
		return Utils.waitForElementPresence(driver,  By.name("firstNameText"), 10);

	}

	public void setIme(String ime) {
		WebElement input = getIme();
		input.clear();
		input.sendKeys(ime);
	}
	public WebElement ImeRquiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti ime.')]"), 10);
	}

	
	
	
	
	public WebElement getPrezime() {
		return Utils.waitForElementPresence(driver, By.xpath(".//div[@id='personSearchLastNameT']/input"), 10);

	}

	public void setPrezime(String prezime) {
		WebElement input = getPrezime();
		input.clear();
		input.sendKeys(prezime);
	}
	public WebElement PrezimeRquiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti prezime.')]"), 10);
	}
	public void removeAllertPrezime(){
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
	
	
	
	
	
	public WebElement getImeRoditelja() {
		return Utils.waitForElementPresence(driver, By.name("middleName"), 10);

	}

	public void setImeRoditelja(String imeroditelja) {
		WebElement input = getImeRoditelja();
		input.clear();
		input.sendKeys(imeroditelja);
	}
	public WebElement ImeRoditeljaRquiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti ime jednog roditelja.')]"), 10);
	}
	
	
	
	
	
	

	// za izbor postojecih titula istrazivaca
	
	public void setTitulaIstrazivaca(String titula) {
		Select status = new Select(Utils.waitForElementPresence(driver, By.name("personTitle"), 10));
		status.selectByVisibleText(titula);
	}


	
	
	
	
	public WebElement getDatumRodjenja() {
		return Utils.waitForElementPresence(driver, By.xpath(".//input[@ng-model='data.date']"), 10);

	}

	public void setDatumRodjenja(String datum) {
		WebElement input = getDatumRodjenja();
		input.clear();
		input.sendKeys(datum);
	}
	public WebElement datumRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti datum rođenja.')]"), 10);
	}
	public WebElement datumFormatError() {
		return Utils.waitForElementPresence(driver,By.xpath("//span[contains (text(),'Datum rođenja mora biti u formatu DD.MM.GGGG')]"), 10);
	}

	
	
	
	
	
	
	public WebElement getDrzavaRodjenja() {
		return Utils.waitForElementPresence(driver, By.name("state"), 10);

	}

	public void setDrzavaRodjenja(String drzava) {
		WebElement input = getDrzavaRodjenja();
		input.clear();
		input.sendKeys(drzava);
	}
	public WebElement drzavaRodjenjaRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti državu rođenja.')]"), 10);
	}
	
	
	
	
	
	public WebElement getGradRodjenja() {
		return Utils.waitForElementPresence(driver, By.name("placeOfBirth"), 10);

	}

	public void setGradRodjenja(String grad) {
		WebElement input = getGradRodjenja();
		input.clear();
		input.sendKeys(grad);
	}
	public WebElement gradRodjenjaRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti mesto rođenja.')]"), 10);
	}
	
	
	
	
	

	public WebElement getOpstinaRodjenja() {
		return Utils.waitForElementPresence(driver, By.name("townShipOfBirth"), 10);

	}

	public void setOpstinaRodjenja(String opstina) {
		WebElement input = getOpstinaRodjenja();
		input.clear();
		input.sendKeys(opstina);
	}
	public WebElement opstinaRodjenjaRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti mesto rođenja.')]"), 10);
	}

	
	
	
	
	public WebElement getDrzavaPrebivalista() {
		return Utils.waitForElementPresence(driver, By.name("stateOfResidence"), 10);

	}

	public void setDrzavaPrebivalista(String drzavaBoravka) {
		WebElement input = getDrzavaPrebivalista();
		input.clear();
		input.sendKeys(drzavaBoravka);
	}
	public WebElement drzavaPrebivalistaRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti državu boravišta ili prebivališta.')]"), 10);
	}
	
	
	
	
	
	
	
	public WebElement getMestoPrebivalista() {
		return Utils.waitForElementPresence(driver, By.name("city"), 10);
	}
	public void setMestoPrebivalista(String mestoPrebivalista) {
		WebElement input = getMestoPrebivalista();
		input.clear();
		input.sendKeys(mestoPrebivalista);
	}
	public WebElement mestoPrebivalistaRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti mesto boravišta ili prebivališta.')]"), 10);
	}
	
	
	
	
	
	
	public WebElement getOpstinaPrebivalista() {
		return Utils.waitForElementPresence(driver, By.name("townShipOfResidence"), 10);
	}
	public void setOpstinaPrebivalista(String opstinaPrebivalista) {
		WebElement input = getOpstinaPrebivalista();
		input.clear();
		input.sendKeys(opstinaPrebivalista);
	}
	public WebElement opstinaPrebivalistaRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti opštinu boravišta ili prebivališta.')]"), 10);
	}

	
	
	
	public WebElement getAdresa() {
		return Utils.waitForElementPresence(driver, By.name("address"), 10);
	}
	public void setAdresa(String adresa) {
		WebElement input = getAdresa();
		input.clear();
		input.sendKeys(adresa);
	}
	public WebElement adresaRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti adresu.')]"), 10);
	}

	
	
	
	public void setPol(String value) {
		Select sl=new Select(Utils.waitForElementPresence(driver, By.name("gender"), 10));
        sl.selectByVisibleText(value);
	}
	public WebElement polRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate izabrati pol.')]"), 10);
	}
	
	
	
	
	public WebElement getJMBG() {
		return Utils.waitForElementPresence(driver, By.name("jmbg"), 10);

	}
	public void setJMBG(String jmbg) {
		WebElement input = getJMBG();
		input.clear();
		input.sendKeys(jmbg);
	}
	public WebElement jmbgRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti JMBG.')]"), 10);
	}
	public WebElement jmbgFormatError() {
		return Utils.waitForElementPresence(driver,By.xpath("//span[contains (text(),'Matični broj se mora sastojati od 13 cifara')]"), 10);
	}
	
	

	
	
	public WebElement getEmail() {
		return Utils.waitForElementPresence(driver, By.name("email"), 10);

	}
	public void setEmail(String mail) {
		WebElement input = getEmail();
		input.clear();
		input.sendKeys(mail);
	}
	public WebElement emailRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti adresu elektronske pošte.')]"), 10);
	}
	
	
	
	
	
	public WebElement getTelefoni() {
		return Utils.waitForElementPresence(driver, By.name("phones"), 10);

	}
	public void setTelefoni(String telefon) {
		WebElement input = getTelefoni();
		input.clear();
		input.sendKeys(telefon);
	}
	public WebElement telefonRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti broj telefona.')]"), 10);
	}
	
	
	
	

	public WebElement getWebAdrese() {
		return Utils.waitForElementPresence(driver, By.name("uri"), 10);

	}
	public void setWebAdrese(String url) {
		WebElement input = getWebAdrese();
		input.clear();
		input.sendKeys(url);

	}
	public WebElement webRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains (text(),'Morate uneti ličnu veb adresu.')]"), 10);
	}
	
	
	
	

	

	
	public void setStatusIstrazivaca(String value) {
		Select sl = new Select(Utils.waitForElementPresence(driver, By.name("personStatus"), 10));
		sl.selectByVisibleText(value);
	}

	
	
	
	public WebElement getButtonSave() {
		return Utils.waitToBeClickable(driver, By.name("btnSave"), 10);
	}

	public WebElement getButtonCancel() {
		return Utils.waitToBeClickable(driver, By.xpath(".//button[@ng-click='reset()']"), 10);
	}

		
	   //cekanje da ucita  stranicu
	public  void getwaitForUrl(){
		 Utils.waitForUrl(driver,"http://localhost:8080/#/persons" , 10);
	}
		 //ucitavanje stranice za dodavanje istrazivaca
	public  void getwaitForUrlIstrazivaca(){
		Utils.waitForUrl(driver,"http://localhost:8080/#/persons/" , 15);
	}
		
			public void unosIstrazivaca(String ime, String prezime, String imeRoditelja,String titula,
					String datumRodj,String drzavaRodj,String gradRodjenja,String opstinaRodj,String drzavaBoravka,
					String mestoBoravka,String opstinaBoravka,String adresa,String value,String jmbg,String email,
					String tel,String veb){
				
				
				
				setIme(ime);
				setPrezime(prezime);
				setImeRoditelja(imeRoditelja);
				setTitulaIstrazivaca(titula);
				setDatumRodjenja(datumRodj);
				setDrzavaRodjenja(drzavaRodj);
				setGradRodjenja(gradRodjenja);
				setOpstinaRodjenja(opstinaRodj);
				setDrzavaPrebivalista(drzavaBoravka);
				setMestoPrebivalista(mestoBoravka);
				setOpstinaPrebivalista(opstinaBoravka);
				setAdresa(adresa);
				setPol(value);
				setJMBG(jmbg);
				setEmail(email);
				setTelefoni(tel);
				setWebAdrese(veb);
				getButtonSave().click();
				 
				}
}
