package zavrsniIspit;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import global.LoginPage;
import global.MenuPage;
import global.ModalSuccessPage;
import global.VerticalMenuPage;
import institucije.pages.OsnovniPodaciPage;
import institucije.pages.PodaciZaProjekte;
import institucije.pages.PodaciZaRegistarPage;
import istrazivaci.pages.AngazovanjeIstrazivaca;
import istrazivaci.pages.AngazovanjeTab;
import istrazivaci.pages.DodajIstrazivacaPage;
import istrazivaci.pages.IstrazivaciListPage;
import istrazivaci.pages.PodaciZaProjekteIstrazivaci;
import istrazivaci.pages.PodaciZaRegistarIstrazivaci;

public class Zadatak2 {

	private WebDriver driver;
	private LoginPage loginPage;
	private MenuPage menuPage;
	private OsnovniPodaciPage osnovniPodaciPage;
	private PodaciZaRegistarPage podaciZaRegistarPage;
	private PodaciZaProjekte podaciZaProjekte;
	private VerticalMenuPage verticalMenuPage;
	private DodajIstrazivacaPage dodajIstrazivacaPage;
	private IstrazivaciListPage istrazivaciListPage;
	private PodaciZaProjekteIstrazivaci podaciZaProjekteIstrazivaci;
	private PodaciZaRegistarIstrazivaci podaciZaRegistarIstrazivaci;
	private ModalSuccessPage modal;
	private AngazovanjeIstrazivaca angazovanjeIstrazivaca;
	private AngazovanjeTab angazovanjeTab;
	
	private String baseUrl;

	@BeforeSuite
	public void setupSelenium() {
		baseUrl = "http://127.0.0.1:8080/#/login";
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.navigate().to(baseUrl);

	}

	@BeforeTest
	public void setupPages() {
		// init pages
		loginPage = new LoginPage(driver);
		menuPage = new MenuPage(driver);
		osnovniPodaciPage = new OsnovniPodaciPage(driver);
		podaciZaRegistarPage = new PodaciZaRegistarPage(driver);
		podaciZaProjekte = new PodaciZaProjekte(driver);
		verticalMenuPage = new VerticalMenuPage(driver);
		dodajIstrazivacaPage = new DodajIstrazivacaPage(driver);
		istrazivaciListPage = new IstrazivaciListPage(driver);
		podaciZaProjekteIstrazivaci = new PodaciZaProjekteIstrazivaci(driver);
		podaciZaRegistarIstrazivaci = new PodaciZaRegistarIstrazivaci(driver);
		modal = new ModalSuccessPage(driver);
		angazovanjeIstrazivaca = new AngazovanjeIstrazivaca(driver);
		angazovanjeTab = new AngazovanjeTab(driver);
	}
	@Test(priority=1)
	public void login() {
		assertTrue(loginPage.pocetnaProvera().isDisplayed());
		assertTrue(loginPage.getUsername().isDisplayed());
		
		loginPage.login("djura@djuraminis.com", "adminvinca");
		assertTrue(menuPage.getMenyIcon().isDisplayed());
		assertEquals(osnovniPodaciPage.getFormBecground().isDisplayed(),true);
		
		
	}
	@Test(priority = 2)
	public void menjanjeJezika(){

		menuPage.getLanguages().click();
		menuPage.getLanguagesSerbLat().click();
	}
	
	
	@Test(priority=3)
	public void dodajIstrazivacaBezParametara(){
	
		verticalMenuPage.getIstrazivaciButton().click();
		dodajIstrazivacaPage.getButtonDodajIstarzivaca().click();
			assertTrue(dodajIstrazivacaPage.getDrzavaRodjenja().isDisplayed());
			assertTrue(dodajIstrazivacaPage.getAdresa().isDisplayed());
			
		
		dodajIstrazivacaPage.setIme("");
		dodajIstrazivacaPage.setPrezime("");
		dodajIstrazivacaPage.setImeRoditelja("");
		
		dodajIstrazivacaPage.setDatumRodjenja("");
		dodajIstrazivacaPage.setDrzavaRodjenja("");
		dodajIstrazivacaPage.setGradRodjenja("");
		dodajIstrazivacaPage.setOpstinaRodjenja("");
		dodajIstrazivacaPage.setDrzavaPrebivalista("");
		dodajIstrazivacaPage.setMestoPrebivalista("");
		dodajIstrazivacaPage.setOpstinaPrebivalista("");
		dodajIstrazivacaPage.setAdresa("");
		
		dodajIstrazivacaPage.setJMBG("");
		dodajIstrazivacaPage.setEmail("");
		dodajIstrazivacaPage.setTelefoni("");
		dodajIstrazivacaPage.setWebAdrese("");
		dodajIstrazivacaPage.getButtonSave().click();
			
			
			assertEquals(false, modal.getSuccessSaveAlert());
			assertTrue(dodajIstrazivacaPage.ImeRquiredError().isDisplayed());
			assertTrue(dodajIstrazivacaPage.PrezimeRquiredError().isDisplayed());
			assertTrue(dodajIstrazivacaPage.jmbgRequiredError().isDisplayed());
			
	
}
	@Test(priority=4)
	public void dodajIstrazivacaBezPrezimena(){
	
		dodajIstrazivacaPage.tabLicniPodaci().click();
			assertTrue(dodajIstrazivacaPage.getDrzavaRodjenja().isDisplayed());
			assertTrue(dodajIstrazivacaPage.getAdresa().isDisplayed());
			
		
		dodajIstrazivacaPage.setIme("Zivan");
		dodajIstrazivacaPage.setJMBG("78654351354");
		
		dodajIstrazivacaPage.getButtonSave().click();
			
			dodajIstrazivacaPage.removeAllertPrezime();
			assertEquals(false, modal.getSuccessSaveAlert());
			assertFalse(dodajIstrazivacaPage.ImeRquiredError().isDisplayed());
			
			assertFalse(dodajIstrazivacaPage.jmbgRequiredError().isDisplayed());
			
	
}

	@Test(priority=5)
	public void dodajIstrazivacaBezImena(){
	
		dodajIstrazivacaPage.tabLicniPodaci().click();
			assertTrue(dodajIstrazivacaPage.getDrzavaRodjenja().isDisplayed());
			assertTrue(dodajIstrazivacaPage.getAdresa().isDisplayed());
			
		
		dodajIstrazivacaPage.setIme("");
		dodajIstrazivacaPage.setPrezime("Markovic");
		
		dodajIstrazivacaPage.setJMBG("78654351354");
		
		dodajIstrazivacaPage.getButtonSave().click();
			
			
			assertEquals(false, modal.getSuccessSaveAlert());
			assertTrue(dodajIstrazivacaPage.ImeRquiredError().isDisplayed());
			assertFalse(dodajIstrazivacaPage.PrezimeRquiredError().isDisplayed());
			assertFalse(dodajIstrazivacaPage.jmbgRequiredError().isDisplayed());
			
	
}
	
	
	@Test(priority=6)
	public void dodajIstrazivacaBezJmbg(){
	
		dodajIstrazivacaPage.tabLicniPodaci().click();
			assertTrue(dodajIstrazivacaPage.getDrzavaRodjenja().isDisplayed());
			assertTrue(dodajIstrazivacaPage.getAdresa().isDisplayed());
			
		
		dodajIstrazivacaPage.setIme("Zivan");
		dodajIstrazivacaPage.setPrezime("Zivanic");
		
		dodajIstrazivacaPage.setJMBG("");
		
		dodajIstrazivacaPage.getButtonSave().click();
			
			
			assertEquals(false, modal.getSuccessSaveAlert());
			assertFalse(dodajIstrazivacaPage.ImeRquiredError().isDisplayed());
			assertFalse(dodajIstrazivacaPage.PrezimeRquiredError().isDisplayed());
			assertTrue(dodajIstrazivacaPage.jmbgRequiredError().isDisplayed());
			
	
}
//	//test ne bi trebalo da prodje jer je za jmbg ne bi trebalo da prodje ako su uneta slova.
//	@Test(priority=7)
//	public void dodajIstrazivacaSlovaZaJmbg(){
//	
//		dodajIstrazivacaPage.tabLicniPodaci().click();
//			assertTrue(dodajIstrazivacaPage.getDrzavaRodjenja().isDisplayed());
//			assertTrue(dodajIstrazivacaPage.getAdresa().isDisplayed());
//			
//		
//		dodajIstrazivacaPage.setIme("Zivan");
//		dodajIstrazivacaPage.setPrezime("Zivanic");
//		
//		dodajIstrazivacaPage.setJMBG("ana");
//		
//		dodajIstrazivacaPage.getButtonSave().click();
//			
//			
//			assertEquals(false, modal.getSuccessSaveAlert());
//			assertFalse(dodajIstrazivacaPage.ImeRquiredError().isDisplayed());
//			assertFalse(dodajIstrazivacaPage.PrezimeRquiredError().isDisplayed());
//			assertTrue(dodajIstrazivacaPage.jmbgFormatError().isDisplayed());
//	}	
//	
	@Test(priority=8)
	public void dodajIstrazivacaPozitiv(){
		
	

		dodajIstrazivacaPage.tabLicniPodaci().click();
		assertTrue(dodajIstrazivacaPage.getDrzavaRodjenja().isDisplayed());
		assertTrue(dodajIstrazivacaPage.getAdresa().isDisplayed());
		
		dodajIstrazivacaPage.setIme("TamaraB11");
		dodajIstrazivacaPage.setPrezime("Istrazivaac");
		
		dodajIstrazivacaPage.setTitulaIstrazivaca("Dr");
		dodajIstrazivacaPage.setDatumRodjenja("29.11.1978");
		dodajIstrazivacaPage.setDrzavaRodjenja("Srbija");
		dodajIstrazivacaPage.setPol("Muški");
		dodajIstrazivacaPage.setJMBG("4664851435453645");
		dodajIstrazivacaPage.setEmail("test@mail.com");
		
		dodajIstrazivacaPage.getButtonSave().click();
			
			assertEquals(true, modal.getSuccessSaveAlert());
			modal.closeSuccessBox();
			
			
	
	
	}
	
	@Test(priority=9)
	public void angazovanjeBezParametara(){
		
	
		assertTrue(angazovanjeIstrazivaca.getModalDialog().isDisplayed());
		
		
		assertTrue(angazovanjeIstrazivaca.getDatumPocetkaAngazovanja().isDisplayed());
		
		angazovanjeIstrazivaca.setZvanjeIstrazivaca("");
		angazovanjeIstrazivaca.setFunkcijaIstrazivaca("");
		angazovanjeIstrazivaca.setDatumPocetkaAngazovanja("");
		angazovanjeIstrazivaca.setDatumPrestankaAngazovanja("");
		dodajIstrazivacaPage.getButtonSave().click();
			
			
		assertTrue(angazovanjeIstrazivaca.datumPocetkaError().isDisplayed());
			
	
	
	}
	
	@Test(priority=10)
	public void angazovanjeSaDRNauka(){
		
	

		
		assertTrue(angazovanjeIstrazivaca.getAngazovanjeProzor().isDisplayed());
		assertTrue(angazovanjeIstrazivaca.getDatumPocetkaAngazovanja().isDisplayed());
		
		angazovanjeIstrazivaca.setZvanjeIstrazivaca("Doktor nauka");
		assertFalse(angazovanjeIstrazivaca.getFunkcijaIstrazivaca().isDisplayed());
		angazovanjeIstrazivaca.setDatumPocetkaAngazovanja("32.11.2017");
		angazovanjeIstrazivaca.setDatumPrestankaAngazovanja("11.12.2017");
		dodajIstrazivacaPage.getButtonSave().click();
			
			
		assertTrue(angazovanjeIstrazivaca.datumPocetkaError().isDisplayed());
			
	
	
	}
	
	@Test(priority=11)
	public void angazovanjeSaAsistent(){
		
	

		
		assertTrue(angazovanjeIstrazivaca.getAngazovanjeProzor().isDisplayed());
		assertTrue(angazovanjeIstrazivaca.getDatumPocetkaAngazovanja().isDisplayed());
		
		angazovanjeIstrazivaca.setZvanjeIstrazivaca("Asistent");
		assertFalse(angazovanjeIstrazivaca.getFunkcijaIstrazivaca().isDisplayed());
		angazovanjeIstrazivaca.setDatumPocetkaAngazovanja("31.13.2017");
		angazovanjeIstrazivaca.setDatumPrestankaAngazovanja("11.12.2017");
		dodajIstrazivacaPage.getButtonSave().click();
			
			
		assertTrue(angazovanjeIstrazivaca.datumPocetkaError().isDisplayed());
			
	
	
	}
	@Test(priority=12)
	public void angazovanjePozitive(){
		
	

		
		assertTrue(angazovanjeIstrazivaca.getAngazovanjeProzor().isDisplayed());
		assertTrue(angazovanjeIstrazivaca.getDatumPocetkaAngazovanja().isDisplayed());
		
		angazovanjeIstrazivaca.setZvanjeIstrazivaca("Asistent");
		assertFalse(angazovanjeIstrazivaca.getFunkcijaIstrazivaca().isDisplayed());
		angazovanjeIstrazivaca.setDatumPocetkaAngazovanja("05.12.2017");
		angazovanjeIstrazivaca.setDatumPrestankaAngazovanja("");
		dodajIstrazivacaPage.getButtonSave().click();
			
			
		assertEquals(true, modal.getSuccessSaveAlert());
		modal.closeSuccessBox();
		
			
	
	
	}
	
	@Test(priority=13)
	public void proveraDaLiJeUTabeli(){
		
	

		
		verticalMenuPage.getIstrazivaciButton().click();
		assertTrue(dodajIstrazivacaPage.getButtonDodajIstarzivaca().isDisplayed());
		
		istrazivaciListPage.isIstrazivacInTabela("TamaraB11", "Istrazivaac");
		istrazivaciListPage.getIstrazivacByImeIPrezime("TamaraB11", "Istrazivaac").click();
			
		assertTrue(dodajIstrazivacaPage.getDrzavaRodjenja().isDisplayed());
		assertTrue(dodajIstrazivacaPage.getAdresa().isDisplayed());
		
		angazovanjeTab.tabAngazovanja().click();
		angazovanjeTab.getButtonAngazujOsobu().click();
		assertTrue(angazovanjeTab.getProcenat().isDisplayed());
		angazovanjeTab.setProcenat("30");
		angazovanjeTab.setDatumPocetkaAngazovanja("26.06.2016");
		angazovanjeTab.getButtonSave().click();
			
	
	
	}
	
	
	
	
	
	
	@Test(priority=28)
	public void logout(){
		
		menuPage.getDropdown().click();
		menuPage.getLogout().click();
		
	}

	@AfterSuite
	public void closeSelenium() {
		driver.quit();
	}

	
}
