package institucije.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helpers.Utils;

public class OsnovniPodaciPage {
	private WebDriver driver;

	public OsnovniPodaciPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getFormBecground() {
		return Utils.waitForElementPresence(driver, By.xpath("//form [@name='Basic']"), 20);
	}
	
	public WebElement tabOsnovniPodaci() {
		return Utils.waitForElementPresence(driver, By.xpath("//ul/li[1]//tab-heading"), 10);
	}
//sve za naziv
	
	public WebElement getNazivInstitucije() {
		return Utils.waitForElementPresence(driver, By.xpath("//input [@name='name']"), 15);
	}
	public void setNazivInstitucije(String naziv) {
		WebElement input = getNazivInstitucije();
		input.clear();
		input.sendKeys(naziv);
	}
	
	public WebElement nazivRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span [contains(text(), 'Morate uneti naziv.')]"), 15);
	}
	
	
	
	//sve za naziv na engleskom
	
	public WebElement getNazivInstitucijeNaEngleskom() {
		return Utils.waitForElementPresence(driver, By.xpath("//input [@name='eng_name']"), 15);
	}
	public void setNazivInstitucijeNaEngleskom(String nazivEN) {
		WebElement input = getNazivInstitucijeNaEngleskom();
		input.clear();
		input.sendKeys(nazivEN);
	}
	
	public WebElement RequiredErrorError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span [contains(text(),'')]"), 15);
	}
	
	
	//sve za drzavu i za novu drzavu
	
	
	public void setDrzava(String drzava){
		Select sl = new Select(driver.findElement(By.xpath("//select [@name='state']")));
		sl.selectByVisibleText(drzava);
	}
	
	
	public WebElement drzavaRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span [contains(text(), 'Morate izabrati državu')]"), 15);
	}
	
	public void novaDrzava(String naziv, String opis ) {
		Select sl = new Select(driver.findElement(By.xpath("//select [@name='state']")));
		sl.selectByVisibleText("Dodaj novu...");
		
		
		 WebElement nazivNoveDrzave = driver.findElement(By.xpath("//input [@name='stateName']"));
		 nazivNoveDrzave.sendKeys(naziv);
		 WebElement opisNoveDrzave = driver.findElement(By.xpath("//input [@name='stateDescription']"));
		 opisNoveDrzave.sendKeys(opis);
		 WebElement buttonSave = driver.findElement(By.xpath("//button [@name='btnSave']"));
		 buttonSave.click();
	}
	
	
	//sve za mesto
	
	public WebElement getMesto() {
		return Utils.waitForElementPresence(driver, By.xpath("//input [@name='place']"), 15);
	}
	public void setMesto(String mesto) {
		WebElement input = getMesto();
		input.clear();
		input.sendKeys(mesto);
	}
	
	public WebElement mestoRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span [contains(text(),'Morate uneti mesto.')]"), 15);
	}
	
	
	
	//sve za opstinu
	
	public WebElement getOpstina() {
		return Utils.waitForElementPresence(driver, By.xpath("//input [@name='townShipText']"), 15);
	}
	public void setOpstina(String opstina) {
		WebElement input = getOpstina();
		input.clear();
		input.sendKeys(opstina);
	}
	
	public WebElement opstinaRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span [contains(text(),'Morate uneti opštinu.')]"), 15);
	}
	
	//sve za ulica i broj
	
	
	public WebElement getUlica() {
		return Utils.waitForElementPresence(driver, By.xpath("//input [@name='address']"), 15);
	}
	public void setUlica(String ulica) {
		WebElement input = getUlica();
		input.clear();
		input.sendKeys(ulica);
	}
	
	public WebElement ulicaRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span [contains(text(),'Morate uneti adresu.')]"), 15);
	}
	
	//web adresa
	
	public WebElement getWebadresa() {
		return Utils.waitForElementPresence(driver, By.xpath("//input [@name='uri']"), 15);
	}
	public void setWebadresa(String webadresa) {
		WebElement input = getWebadresa();
		input.clear();
		input.sendKeys(webadresa);
	}
	
	public WebElement webadresaRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span [contains(text(),'Morate uneti veb adresu.')]"), 15);
	}
	
	//sve za email
	
	public WebElement getEmail() {
		return Utils.waitForElementPresence(driver, By.xpath("//input [@name='email']"), 15);
	}
	public void setEmail(String email) {
		WebElement input = getEmail();
		input.clear();
		input.sendKeys(email);
	}
	
	public WebElement emailRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span [contains(text(),'Morate uneti adresu elektronske pošte.')]"), 15);
	}
	
	//sve za telefon
	
	public WebElement getTelefon() {
		return Utils.waitForElementPresence(driver, By.xpath("//input [@name='phone']"), 15);
	}
	public void setTelefon(String telefon) {
		WebElement input = getTelefon();
		input.clear();
		input.sendKeys(telefon);
	}
	
	public WebElement telefonRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span [contains(text(),'Morate uneti broj telefona.')]"), 15);
	}
	
	// sve za skraceni naziv
	
	public WebElement getSkracenNaziv() {
		return Utils.waitForElementPresence(driver, By.xpath("//input [@name='acro']"), 15);
	}
	public void setSkracenNaziv(String kracinaziv) {
		WebElement input = getSkracenNaziv();
		input.clear();
		input.sendKeys(kracinaziv);
	}
	
	
	
	
	
	//sve za nadredjenu instituciju
	
	public void setnadredjenaInstitucija(String naziv) {
		Select sl = new Select(driver.findElement(By.xpath("//select [@name='supetInstitution']")));
		sl.selectByVisibleText(naziv);
		
//		 WebElement FTN = driver.findElement(By.id("select2-result"));
//		 FTN.click();
	}
	public WebElement nadredjenaRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span [contains(text(),'Morate izabrati nadređenu instituciju.')]"), 15);
	}
	
	
	
	public WebElement getButtonSaveAllPage() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id='page-content']/div/div/div/div/div/div/div/div/div/div[1]/ng-include/div/div/div/div/div[2]/form/div[14]/div[2]/div/button[2]"), 10);
	}
	
	
	public void osnovniPodaciForma(String naziv, String nazivEN, String drzava, String mesto, String opstina, String ulica, 
			String webadresa, String email, String telefon, String kracinaziv,String nadredjenaInstitucija) {
		setNazivInstitucije(naziv);
		setNazivInstitucijeNaEngleskom(nazivEN);
		setDrzava(drzava);
		setMesto(mesto);
		setOpstina(opstina);
		setUlica(ulica);
		setWebadresa(webadresa);
		setEmail(email);
		setTelefon(telefon);
		setSkracenNaziv(kracinaziv);
		setnadredjenaInstitucija(nadredjenaInstitucija);
		
		
		getButtonSaveAllPage().click();
	}
	
	
	
	
//	public WebElement getIspitnaPrijavaTable() {
//		return Utils.waitForElementPresence(driver, By.className("jh-table"), 10);
//	}
//
//	public List<WebElement> getTableRows() {
//		return this.getIspitnaPrijavaTable().findElements(By.tagName("tr"));
//	}
}
