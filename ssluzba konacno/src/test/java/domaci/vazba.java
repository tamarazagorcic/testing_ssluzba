package domaci;

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
import istrazivaci.pages.DodajIstrazivacaPage;

public class vazba {

	private WebDriver driver;
	private LoginPage loginPage;
	private MenuPage menuPage;
	private OsnovniPodaciPage osnovniPodaciPage;
	private PodaciZaRegistarPage podaciZaRegistarPage;
	private PodaciZaProjekte podaciZaProjekte;
	private VerticalMenuPage verticalMenuPage;
	private DodajIstrazivacaPage dodajIstrazivacaPage;
	private ModalSuccessPage modal;
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
		modal = new ModalSuccessPage(driver);
		
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
	
	@Test(priority = 3)
	public void podaciBezParametara(){
		osnovniPodaciPage.tabOsnovniPodaci().click();
			assertTrue(osnovniPodaciPage.getNazivInstitucije().isDisplayed());
			assertTrue(osnovniPodaciPage.getButtonSaveAllPage().isDisplayed());
			assertTrue(osnovniPodaciPage.getEmail().isDisplayed());
			assertTrue(osnovniPodaciPage.getOpstina().isDisplayed());
			assertTrue(osnovniPodaciPage.getSkracenNaziv().isDisplayed());
		osnovniPodaciPage.setNazivInstitucije(""); 
		osnovniPodaciPage.setNazivInstitucijeNaEngleskom("");
		osnovniPodaciPage.setDrzava("Srbija");
		osnovniPodaciPage.setMesto("");
		osnovniPodaciPage.setOpstina("");
		osnovniPodaciPage.setUlica("");
		osnovniPodaciPage.setWebadresa("");
		osnovniPodaciPage.setEmail("");
		osnovniPodaciPage.setTelefon("");
		osnovniPodaciPage.setSkracenNaziv("");
		osnovniPodaciPage.setnadredjenaInstitucija("Fakultet tehničkih nauka");
		
		osnovniPodaciPage.getButtonSaveAllPage().click();
		
		assertTrue(osnovniPodaciPage.nazivRequiredError().isDisplayed());
		assertTrue(osnovniPodaciPage.mestoRequiredError().isDisplayed());
		assertTrue(osnovniPodaciPage.ulicaRequiredError().isDisplayed());
		assertTrue(osnovniPodaciPage.webadresaRequiredError().isDisplayed());
		assertTrue(osnovniPodaciPage.emailRequiredError().isDisplayed());
		assertTrue(osnovniPodaciPage.telefonRequiredError().isDisplayed());
		
		
	}
	
	@Test(priority = 4)
	public void podaciBezNaziva(){
		osnovniPodaciPage.tabOsnovniPodaci().click();
			assertTrue(osnovniPodaciPage.getNazivInstitucije().isDisplayed());
			assertTrue(osnovniPodaciPage.getButtonSaveAllPage().isDisplayed());
			assertTrue(osnovniPodaciPage.getEmail().isDisplayed());
			assertTrue(osnovniPodaciPage.getOpstina().isDisplayed());
			assertTrue(osnovniPodaciPage.getSkracenNaziv().isDisplayed());
		osnovniPodaciPage.setNazivInstitucije(""); 
		osnovniPodaciPage.setNazivInstitucijeNaEngleskom("Biology institute");
		osnovniPodaciPage.setDrzava("Srbija");
		osnovniPodaciPage.setMesto("Novi Sad");
		osnovniPodaciPage.setOpstina("Novi Sad");
		osnovniPodaciPage.setUlica("nepoznata");
		osnovniPodaciPage.setWebadresa("bio.us.rs.un");
		osnovniPodaciPage.setEmail("biology@gmail.com");
		osnovniPodaciPage.setTelefon("172183483476");
		osnovniPodaciPage.setSkracenNaziv("biologijica");
		osnovniPodaciPage.setnadredjenaInstitucija("Fakultet tehničkih nauka");
		
		osnovniPodaciPage.getButtonSaveAllPage().click();
		
		assertTrue(osnovniPodaciPage.nazivRequiredError().isDisplayed());
		assertEquals(false,modal.getSuccessSaveAlert());
		
		
		
	}
	// trebalo bi da test padne jer naziv na Engleskom stoji kao obavezno pplje ali ga ipak sacuva i test pada.
	@Test(priority = 5)
	public void podaciBezEngleskogNaziva(){
		osnovniPodaciPage.tabOsnovniPodaci().click();
			assertTrue(osnovniPodaciPage.getNazivInstitucije().isDisplayed());
			assertTrue(osnovniPodaciPage.getButtonSaveAllPage().isDisplayed());
			assertTrue(osnovniPodaciPage.getEmail().isDisplayed());
			assertTrue(osnovniPodaciPage.getOpstina().isDisplayed());
			assertTrue(osnovniPodaciPage.getSkracenNaziv().isDisplayed());
		osnovniPodaciPage.setNazivInstitucije("Institut Biologija"); 
		osnovniPodaciPage.setNazivInstitucijeNaEngleskom("");
		osnovniPodaciPage.setDrzava("Srbija");
		osnovniPodaciPage.setMesto("Novi Sad");
		osnovniPodaciPage.setOpstina("Novi Sad");
		osnovniPodaciPage.setUlica("nepoznata");
		osnovniPodaciPage.setWebadresa("bio.us.rs.un");
		osnovniPodaciPage.setEmail("biology@gmail.com");
		osnovniPodaciPage.setTelefon("172183483476");
		osnovniPodaciPage.setSkracenNaziv("biologijica");
		osnovniPodaciPage.setnadredjenaInstitucija("Fakultet tehničkih nauka");
		
		osnovniPodaciPage.getButtonSaveAllPage().click();
		
		assertTrue(osnovniPodaciPage.nazivRequiredError().isDisplayed());
		assertEquals(false,modal.getSuccessSaveAlert());
		modal.closeSuccessBox();
		
		
		
	}
	
	@Test(priority = 6)
	public void podaciBezMesta(){
		osnovniPodaciPage.tabOsnovniPodaci().click();
			assertTrue(osnovniPodaciPage.getNazivInstitucije().isDisplayed());
			assertTrue(osnovniPodaciPage.getButtonSaveAllPage().isDisplayed());
			assertTrue(osnovniPodaciPage.getEmail().isDisplayed());
			assertTrue(osnovniPodaciPage.getOpstina().isDisplayed());
			assertTrue(osnovniPodaciPage.getSkracenNaziv().isDisplayed());
		osnovniPodaciPage.setNazivInstitucije("Institut Biologija"); 
		osnovniPodaciPage.setNazivInstitucijeNaEngleskom("Biology institute");
		osnovniPodaciPage.setDrzava("Srbija");
		osnovniPodaciPage.setMesto("");
		osnovniPodaciPage.setOpstina("Novi Sad");
		osnovniPodaciPage.setUlica("nepoznata");
		osnovniPodaciPage.setWebadresa("bio.us.rs.un");
		osnovniPodaciPage.setEmail("biology@gmail.com");
		osnovniPodaciPage.setTelefon("172183483476");
		osnovniPodaciPage.setSkracenNaziv("biologijica");
		osnovniPodaciPage.setnadredjenaInstitucija("Fakultet tehničkih nauka");
		
		osnovniPodaciPage.getButtonSaveAllPage().click();
		
		assertTrue(osnovniPodaciPage.mestoRequiredError().isDisplayed());
		assertEquals(false,modal.getSuccessSaveAlert());
		
		
		
		
	}
	@Test(priority = 7)
	public void podaciBezUlice(){
		osnovniPodaciPage.tabOsnovniPodaci().click();
			assertTrue(osnovniPodaciPage.getNazivInstitucije().isDisplayed());
			assertTrue(osnovniPodaciPage.getButtonSaveAllPage().isDisplayed());
			assertTrue(osnovniPodaciPage.getEmail().isDisplayed());
			assertTrue(osnovniPodaciPage.getOpstina().isDisplayed());
			assertTrue(osnovniPodaciPage.getSkracenNaziv().isDisplayed());
		osnovniPodaciPage.setNazivInstitucije("Institut Biologija"); 
		osnovniPodaciPage.setNazivInstitucijeNaEngleskom("Biology institute");
		osnovniPodaciPage.setDrzava("Srbija");
		osnovniPodaciPage.setMesto("Novi Sad");
		osnovniPodaciPage.setOpstina("Novi Sad");
		osnovniPodaciPage.setUlica("");
		osnovniPodaciPage.setWebadresa("bio.us.rs.un");
		osnovniPodaciPage.setEmail("biology@gmail.com");
		osnovniPodaciPage.setTelefon("172183483476");
		osnovniPodaciPage.setSkracenNaziv("biologijica");
		osnovniPodaciPage.setnadredjenaInstitucija("Fakultet tehničkih nauka");
		
		osnovniPodaciPage.getButtonSaveAllPage().click();
		
		assertTrue(osnovniPodaciPage.ulicaRequiredError().isDisplayed());
		assertEquals(false,modal.getSuccessSaveAlert());
	
		
		
		
	}
	
	@Test(priority = 8)
	public void podaciBezWebAdrese(){
		osnovniPodaciPage.tabOsnovniPodaci().click();
			assertTrue(osnovniPodaciPage.getNazivInstitucije().isDisplayed());
			assertTrue(osnovniPodaciPage.getButtonSaveAllPage().isDisplayed());
			assertTrue(osnovniPodaciPage.getEmail().isDisplayed());
			assertTrue(osnovniPodaciPage.getOpstina().isDisplayed());
			assertTrue(osnovniPodaciPage.getSkracenNaziv().isDisplayed());
		osnovniPodaciPage.setNazivInstitucije("Institut Biologija"); 
		osnovniPodaciPage.setNazivInstitucijeNaEngleskom("Biology institute");
		osnovniPodaciPage.setDrzava("Srbija");
		osnovniPodaciPage.setMesto("Novi Sad");
		osnovniPodaciPage.setOpstina("Novi Sad");
		osnovniPodaciPage.setUlica("neznana");
		osnovniPodaciPage.setWebadresa("");
		osnovniPodaciPage.setEmail("biology@gmail.com");
		osnovniPodaciPage.setTelefon("172183483476");
		osnovniPodaciPage.setSkracenNaziv("biologijica");
		osnovniPodaciPage.setnadredjenaInstitucija("Fakultet tehničkih nauka");
		
		osnovniPodaciPage.getButtonSaveAllPage().click();
		
		assertTrue(osnovniPodaciPage.webadresaRequiredError().isDisplayed());
		assertEquals(false,modal.getSuccessSaveAlert());
	
		
		
		
	}
	
	@Test(priority = 9)
	public void podaciBezemail(){
		osnovniPodaciPage.tabOsnovniPodaci().click();
			assertTrue(osnovniPodaciPage.getNazivInstitucije().isDisplayed());
			assertTrue(osnovniPodaciPage.getButtonSaveAllPage().isDisplayed());
			assertTrue(osnovniPodaciPage.getEmail().isDisplayed());
			assertTrue(osnovniPodaciPage.getOpstina().isDisplayed());
			assertTrue(osnovniPodaciPage.getSkracenNaziv().isDisplayed());
		osnovniPodaciPage.setNazivInstitucije("Institut Biologija"); 
		osnovniPodaciPage.setNazivInstitucijeNaEngleskom("Biology institute");
		osnovniPodaciPage.setDrzava("Srbija");
		osnovniPodaciPage.setMesto("Novi Sad");
		osnovniPodaciPage.setOpstina("Novi Sad");
		osnovniPodaciPage.setUlica("neznana");
		osnovniPodaciPage.setWebadresa("bio.us.rs.un");
		osnovniPodaciPage.setEmail("");
		osnovniPodaciPage.setTelefon("172183483476");
		osnovniPodaciPage.setSkracenNaziv("biologijica");
		osnovniPodaciPage.setnadredjenaInstitucija("Fakultet tehničkih nauka");
		
		osnovniPodaciPage.getButtonSaveAllPage().click();
		
		assertTrue(osnovniPodaciPage.emailRequiredError().isDisplayed());
		assertEquals(false,modal.getSuccessSaveAlert());
	
		
		
		
	}
	
	@Test(priority = 10)
	public void podaciBeztelefona(){
		osnovniPodaciPage.tabOsnovniPodaci().click();
			assertTrue(osnovniPodaciPage.getNazivInstitucije().isDisplayed());
			assertTrue(osnovniPodaciPage.getButtonSaveAllPage().isDisplayed());
			assertTrue(osnovniPodaciPage.getEmail().isDisplayed());
			assertTrue(osnovniPodaciPage.getOpstina().isDisplayed());
			assertTrue(osnovniPodaciPage.getSkracenNaziv().isDisplayed());
		osnovniPodaciPage.setNazivInstitucije("Institut Biologija"); 
		osnovniPodaciPage.setNazivInstitucijeNaEngleskom("Biology institute");
		osnovniPodaciPage.setDrzava("Srbija");
		osnovniPodaciPage.setMesto("Novi Sad");
		osnovniPodaciPage.setOpstina("Novi Sad");
		osnovniPodaciPage.setUlica("neznana");
		osnovniPodaciPage.setWebadresa("bio.us.rs.un");
		osnovniPodaciPage.setEmail("biology@gmail.com");
		osnovniPodaciPage.setTelefon("");
		osnovniPodaciPage.setSkracenNaziv("biologijica");
		osnovniPodaciPage.setnadredjenaInstitucija("Fakultet tehničkih nauka");
		
		osnovniPodaciPage.getButtonSaveAllPage().click();
		
			assertTrue(osnovniPodaciPage.telefonRequiredError().isDisplayed());
			assertEquals(false,modal.getSuccessSaveAlert());
	
		
		
		
	}
	@Test(priority = 11)
	public void osnovniPodaciPozitiv() {
		
		osnovniPodaciPage.tabOsnovniPodaci().click();
			assertTrue(osnovniPodaciPage.getNazivInstitucije().isDisplayed());
			assertTrue(osnovniPodaciPage.getEmail().isDisplayed());
			assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8080/#/admin-institution/");
		
		osnovniPodaciPage.osnovniPodaciForma("Institut Biologija", "Biology institute", "Srbija", "Novi Sad", "Novi Sad", "nepoznata", "bio.us.rs.un",
				"biology@gmail.com", "172183483476", "biologijica", "Fakultet tehničkih nauka");
		
			assertEquals(true,modal.getSuccessSaveAlert());
		modal.closeSuccessBox();
		
	}
	
	@Test(priority = 12)
	public void podaciZaRegistarbezParametara() {
		podaciZaRegistarPage.tabPodaciZaRegistar().click();
			assertTrue(podaciZaRegistarPage.getbrojAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getButtonSave().isDisplayed());
			assertTrue(podaciZaRegistarPage.getDatumAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getOsnivac().isDisplayed());
			assertTrue(podaciZaRegistarPage.getPib().isDisplayed());
		
		podaciZaRegistarPage.setPib("");
		podaciZaRegistarPage.setMaticniBroj("");
		podaciZaRegistarPage.setbrojAkreditacije("");
		podaciZaRegistarPage.setDatumAkreditacije("");
		podaciZaRegistarPage.setNazivInstitucijeAkreditacije("");
		podaciZaRegistarPage.setNapomenaoRegistru("");
		podaciZaRegistarPage.setVrstaInstitucije("");
		podaciZaRegistarPage.setOsnivac("");
		podaciZaRegistarPage.setDatumOsnivanja("");
		podaciZaRegistarPage.setResenjeOosnivanju("");
		podaciZaRegistarPage.setVlasnickaStruktura("");
		podaciZaRegistarPage.getButtonSave().click();
		
		
			assertEquals(false,modal.getSuccessSaveAlert());
			assertTrue(podaciZaRegistarPage.pibRequiredError().isDisplayed());
			assertTrue(podaciZaRegistarPage.maticniBrojRequiredError().isDisplayed());
			assertTrue(podaciZaRegistarPage.akreditacijaBrojRequiredError().isDisplayed());
			assertTrue(podaciZaRegistarPage.akreditacijaDatumRequiredError().isDisplayed());
			assertTrue(podaciZaRegistarPage.nazivInstitucijeRequiredError().isDisplayed());
			
		
		
	}
	
	@Test(priority = 13)
	public void podaciZaRegistarBezPib() {
		podaciZaRegistarPage.tabPodaciZaRegistar().click();
			assertTrue(podaciZaRegistarPage.getbrojAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getButtonSave().isDisplayed());
			assertTrue(podaciZaRegistarPage.getDatumAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getOsnivac().isDisplayed());
			assertTrue(podaciZaRegistarPage.getPib().isDisplayed());
		
		podaciZaRegistarPage.setPib("");
		podaciZaRegistarPage.setMaticniBroj("15021988805055");
		podaciZaRegistarPage.setbrojAkreditacije("454");
		podaciZaRegistarPage.setDatumAkreditacije("15.02.2016");
		podaciZaRegistarPage.setNazivInstitucijeAkreditacije("Institut Biologija");
		podaciZaRegistarPage.setNapomenaoRegistru("nema napomene");
		podaciZaRegistarPage.setVrstaInstitucije("Univerzitet");
		podaciZaRegistarPage.setOsnivac("drzava");
		podaciZaRegistarPage.setDatumOsnivanja("11.11.1999");
		podaciZaRegistarPage.setResenjeOosnivanju("43");
		podaciZaRegistarPage.setVlasnickaStruktura("Državna");
		podaciZaRegistarPage.getButtonSave().click();
		
		
			assertEquals(false,modal.getSuccessSaveAlert());
			assertTrue(podaciZaRegistarPage.pibRequiredError().isDisplayed());
			
			
		
		
	}
	@Test(priority = 14)
	public void podaciZaRegistarPogresanPib() {
		podaciZaRegistarPage.tabPodaciZaRegistar().click();
			assertTrue(podaciZaRegistarPage.getbrojAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getButtonSave().isDisplayed());
			assertTrue(podaciZaRegistarPage.getDatumAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getOsnivac().isDisplayed());
			assertTrue(podaciZaRegistarPage.getPib().isDisplayed());
		
		podaciZaRegistarPage.setPib("a");
		podaciZaRegistarPage.setMaticniBroj("15021988805055");
		podaciZaRegistarPage.setbrojAkreditacije("454");
		podaciZaRegistarPage.setDatumAkreditacije("15.02.2016");
		podaciZaRegistarPage.setNazivInstitucijeAkreditacije("Institut Biologija");
		podaciZaRegistarPage.setNapomenaoRegistru("nema napomene");
		podaciZaRegistarPage.setVrstaInstitucije("Univerzitet");
		podaciZaRegistarPage.setOsnivac("drzava");
		podaciZaRegistarPage.setDatumOsnivanja("11.11.1999");
		podaciZaRegistarPage.setResenjeOosnivanju("43");
		podaciZaRegistarPage.setVlasnickaStruktura("Državna");
		podaciZaRegistarPage.getButtonSave().click();
		
		
			assertEquals(false,modal.getSuccessSaveAlert());
			assertTrue(podaciZaRegistarPage.pibFormatError().isDisplayed());
			;
			
		
		
	}
	@Test(priority = 15)
	public void podaciZaRegistarbezMB() {
		podaciZaRegistarPage.tabPodaciZaRegistar().click();
			assertTrue(podaciZaRegistarPage.getbrojAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getButtonSave().isDisplayed());
			assertTrue(podaciZaRegistarPage.getDatumAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getOsnivac().isDisplayed());
			assertTrue(podaciZaRegistarPage.getPib().isDisplayed());
		
		podaciZaRegistarPage.setPib("1535251");
		podaciZaRegistarPage.setMaticniBroj("");
		podaciZaRegistarPage.setbrojAkreditacije("454");
		podaciZaRegistarPage.setDatumAkreditacije("15.02.2016");
		podaciZaRegistarPage.setNazivInstitucijeAkreditacije("Institut Biologija");
		podaciZaRegistarPage.setNapomenaoRegistru("nema napomene");
		podaciZaRegistarPage.setVrstaInstitucije("Univerzitet");
		podaciZaRegistarPage.setOsnivac("drzava");
		podaciZaRegistarPage.setDatumOsnivanja("11.11.1999");
		podaciZaRegistarPage.setResenjeOosnivanju("43");
		podaciZaRegistarPage.setVlasnickaStruktura("Državna");
		podaciZaRegistarPage.getButtonSave().click();
		
		
			assertEquals(false,modal.getSuccessSaveAlert());
			assertFalse(podaciZaRegistarPage.pibRequiredError().isDisplayed());
			assertTrue(podaciZaRegistarPage.maticniBrojRequiredError().isDisplayed());
			
		
		
	}
	@Test(priority = 16)
	public void podaciZaRegistarSa12CifaraMB() {
		podaciZaRegistarPage.tabPodaciZaRegistar().click();
			assertTrue(podaciZaRegistarPage.getbrojAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getButtonSave().isDisplayed());
			assertTrue(podaciZaRegistarPage.getDatumAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getOsnivac().isDisplayed());
			assertTrue(podaciZaRegistarPage.getPib().isDisplayed());
		
		podaciZaRegistarPage.setPib("1535251");
		podaciZaRegistarPage.setMaticniBroj("1502198880505");
		podaciZaRegistarPage.setbrojAkreditacije("454");
		podaciZaRegistarPage.setDatumAkreditacije("15.02.2016");
		podaciZaRegistarPage.setNazivInstitucijeAkreditacije("Institut Biologija");
		podaciZaRegistarPage.setNapomenaoRegistru("nema napomene");
		podaciZaRegistarPage.setVrstaInstitucije("Univerzitet");
		podaciZaRegistarPage.setOsnivac("drzava");
		podaciZaRegistarPage.setDatumOsnivanja("11.11.1999");
		podaciZaRegistarPage.setResenjeOosnivanju("43");
		podaciZaRegistarPage.setVlasnickaStruktura("Državna");
		podaciZaRegistarPage.getButtonSave().click();
		
		
			assertEquals(false,modal.getSuccessSaveAlert());
			assertFalse(podaciZaRegistarPage.pibRequiredError().isDisplayed());
			assertTrue(podaciZaRegistarPage.maticniBrojFormatError().isDisplayed());
			modal.closeSuccessBox();
			
		// test pada zato sto me bi trebalo da se sacuva MB od 12 cifara	
		
		
	}
	
	@Test(priority = 17)
	public void podaciZaRegistarSa14Cifara() {
		podaciZaRegistarPage.tabPodaciZaRegistar().click();
			assertTrue(podaciZaRegistarPage.getbrojAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getButtonSave().isDisplayed());
			assertTrue(podaciZaRegistarPage.getDatumAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getOsnivac().isDisplayed());
			assertTrue(podaciZaRegistarPage.getPib().isDisplayed());
		
		podaciZaRegistarPage.setPib("1535251");
		podaciZaRegistarPage.setMaticniBroj("150219888050555");
		podaciZaRegistarPage.setbrojAkreditacije("454");
		podaciZaRegistarPage.setDatumAkreditacije("15.02.2016");
		podaciZaRegistarPage.setNazivInstitucijeAkreditacije("Institut Biologija");
		podaciZaRegistarPage.setNapomenaoRegistru("nema napomene");
		podaciZaRegistarPage.setVrstaInstitucije("Univerzitet");
		podaciZaRegistarPage.setOsnivac("drzava");
		podaciZaRegistarPage.setDatumOsnivanja("11.11.1999");
		podaciZaRegistarPage.setResenjeOosnivanju("43");
		podaciZaRegistarPage.setVlasnickaStruktura("Državna");
		podaciZaRegistarPage.getButtonSave().click();
		
		
			assertEquals(false,modal.getSuccessSaveAlert());
			
			assertTrue(podaciZaRegistarPage.maticniBrojFormatError().isDisplayed());
			modal.closeSuccessBox();
			
			
		// test pada zato sto ne bi trebalo da se sacuva pib sa 14 cifara!!!
		
	}
	@Test(priority = 18)
	public void podaciZaRegistarSlovaZaMB() {
		podaciZaRegistarPage.tabPodaciZaRegistar().click();
			assertTrue(podaciZaRegistarPage.getbrojAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getButtonSave().isDisplayed());
			assertTrue(podaciZaRegistarPage.getDatumAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getOsnivac().isDisplayed());
			assertTrue(podaciZaRegistarPage.getPib().isDisplayed());
		
		podaciZaRegistarPage.setPib("1535251");
		podaciZaRegistarPage.setMaticniBroj("ana");
		podaciZaRegistarPage.setbrojAkreditacije("454");
		podaciZaRegistarPage.setDatumAkreditacije("15.02.2016");
		podaciZaRegistarPage.setNazivInstitucijeAkreditacije("Institut Biologija");
		podaciZaRegistarPage.setNapomenaoRegistru("nema napomene");
		podaciZaRegistarPage.setVrstaInstitucije("Univerzitet");
		podaciZaRegistarPage.setOsnivac("drzava");
		podaciZaRegistarPage.setDatumOsnivanja("11.11.1999");
		podaciZaRegistarPage.setResenjeOosnivanju("43");
		podaciZaRegistarPage.setVlasnickaStruktura("Državna");
		podaciZaRegistarPage.getButtonSave().click();
		
		
			assertEquals(false,modal.getSuccessSaveAlert());
			assertFalse(podaciZaRegistarPage.pibRequiredError().isDisplayed());
			assertTrue(podaciZaRegistarPage.maticniBrojFormatError().isDisplayed());
			
			
		
		
	}
	@Test(priority = 19)
	public void podaciZaRegistarBezBrojaAkreditacije() {
		podaciZaRegistarPage.tabPodaciZaRegistar().click();
			assertTrue(podaciZaRegistarPage.getbrojAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getButtonSave().isDisplayed());
			assertTrue(podaciZaRegistarPage.getDatumAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getOsnivac().isDisplayed());
			assertTrue(podaciZaRegistarPage.getPib().isDisplayed());
		
		podaciZaRegistarPage.setPib("1535251");
		podaciZaRegistarPage.setMaticniBroj("15021988805055");
		podaciZaRegistarPage.setbrojAkreditacije("");
		podaciZaRegistarPage.setDatumAkreditacije("15.02.2016");
		podaciZaRegistarPage.setNazivInstitucijeAkreditacije("Institut Biologija");
		podaciZaRegistarPage.setNapomenaoRegistru("nema napomene");
		podaciZaRegistarPage.setVrstaInstitucije("Univerzitet");
		podaciZaRegistarPage.setOsnivac("drzava");
		podaciZaRegistarPage.setDatumOsnivanja("11.11.1999");
		podaciZaRegistarPage.setResenjeOosnivanju("43");
		podaciZaRegistarPage.setVlasnickaStruktura("Državna");
		podaciZaRegistarPage.getButtonSave().click();
		
		
			assertEquals(false,modal.getSuccessSaveAlert());
			
			assertTrue(podaciZaRegistarPage.akreditacijaBrojRequiredError().isDisplayed());
			
			
		
		
	}
	
	@Test(priority = 20)
	public void podaciZaRegistarBezDatuma() {
		podaciZaRegistarPage.tabPodaciZaRegistar().click();
			assertTrue(podaciZaRegistarPage.getbrojAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getButtonSave().isDisplayed());
			assertTrue(podaciZaRegistarPage.getDatumAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getOsnivac().isDisplayed());
			assertTrue(podaciZaRegistarPage.getPib().isDisplayed());
		
		podaciZaRegistarPage.setPib("1535251");
		podaciZaRegistarPage.setMaticniBroj("15021988805055");
		podaciZaRegistarPage.setbrojAkreditacije("454");
		podaciZaRegistarPage.setDatumAkreditacije("");
		podaciZaRegistarPage.setNazivInstitucijeAkreditacije("Institut Biologija");
		podaciZaRegistarPage.setNapomenaoRegistru("nema napomene");
		podaciZaRegistarPage.setVrstaInstitucije("Univerzitet");
		podaciZaRegistarPage.setOsnivac("drzava");
		podaciZaRegistarPage.setDatumOsnivanja("11.11.1999");
		podaciZaRegistarPage.setResenjeOosnivanju("43");
		podaciZaRegistarPage.setVlasnickaStruktura("Državna");
		podaciZaRegistarPage.getButtonSave().click();
		
		
			assertEquals(false,modal.getSuccessSaveAlert());
			
			assertTrue(podaciZaRegistarPage.akreditacijaDatumRequiredError().isDisplayed());
			
			
		
		
	}
	@Test(priority = 21)
	public void podaciZaRegistarDatumVise() {
		podaciZaRegistarPage.tabPodaciZaRegistar().click();
			assertTrue(podaciZaRegistarPage.getbrojAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getButtonSave().isDisplayed());
			assertTrue(podaciZaRegistarPage.getDatumAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getOsnivac().isDisplayed());
			assertTrue(podaciZaRegistarPage.getPib().isDisplayed());
		
		podaciZaRegistarPage.setPib("1535251");
		podaciZaRegistarPage.setMaticniBroj("15021988805055");
		podaciZaRegistarPage.setbrojAkreditacije("454");
		podaciZaRegistarPage.setDatumAkreditacije("32.03.2016");
		podaciZaRegistarPage.setNazivInstitucijeAkreditacije("Institut Biologija");
		podaciZaRegistarPage.setNapomenaoRegistru("nema napomene");
		podaciZaRegistarPage.setVrstaInstitucije("Univerzitet");
		podaciZaRegistarPage.setOsnivac("drzava");
		podaciZaRegistarPage.setDatumOsnivanja("11.11.1999");
		podaciZaRegistarPage.setResenjeOosnivanju("43");
		podaciZaRegistarPage.setVlasnickaStruktura("Državna");
		podaciZaRegistarPage.getButtonSave().click();
		
		
			assertEquals(false,modal.getSuccessSaveAlert());
			
			assertTrue(podaciZaRegistarPage.akreditacijaDatumRequiredError().isDisplayed());
		
			
		
		
	}
	@Test(priority = 22)
	public void podaciZaRegistarMesecVise() {
		podaciZaRegistarPage.tabPodaciZaRegistar().click();
			assertTrue(podaciZaRegistarPage.getbrojAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getButtonSave().isDisplayed());
			assertTrue(podaciZaRegistarPage.getDatumAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getOsnivac().isDisplayed());
			assertTrue(podaciZaRegistarPage.getPib().isDisplayed());
		
		podaciZaRegistarPage.setPib("1535251");
		podaciZaRegistarPage.setMaticniBroj("15021988805055");
		podaciZaRegistarPage.setbrojAkreditacije("454");
		podaciZaRegistarPage.setDatumAkreditacije("15.13.2016");
		podaciZaRegistarPage.setNazivInstitucijeAkreditacije("Institut Biologija");
		podaciZaRegistarPage.setNapomenaoRegistru("nema napomene");
		podaciZaRegistarPage.setVrstaInstitucije("Univerzitet");
		podaciZaRegistarPage.setOsnivac("drzava");
		podaciZaRegistarPage.setDatumOsnivanja("11.11.1999");
		podaciZaRegistarPage.setResenjeOosnivanju("43");
		podaciZaRegistarPage.setVlasnickaStruktura("Državna");
		podaciZaRegistarPage.getButtonSave().click();
		
		
			assertEquals(false,modal.getSuccessSaveAlert());
			
			assertTrue(podaciZaRegistarPage.akreditacijaDatumRequiredError().isDisplayed());
			
			
		
		
	}
	
	
	@Test(priority = 23)
	public void podaciZaRegistarBezInstitucije() {
		podaciZaRegistarPage.tabPodaciZaRegistar().click();
			assertTrue(podaciZaRegistarPage.getbrojAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getButtonSave().isDisplayed());
			assertTrue(podaciZaRegistarPage.getDatumAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getOsnivac().isDisplayed());
			assertTrue(podaciZaRegistarPage.getPib().isDisplayed());
		
		podaciZaRegistarPage.setPib("1535251");
		podaciZaRegistarPage.setMaticniBroj("15021988805055");
		podaciZaRegistarPage.setbrojAkreditacije("454");
		podaciZaRegistarPage.setDatumAkreditacije("15.02.2016");
		podaciZaRegistarPage.setNazivInstitucijeAkreditacije("");
		podaciZaRegistarPage.setNapomenaoRegistru("nema napomene");
		podaciZaRegistarPage.setVrstaInstitucije("Univerzitet");
		podaciZaRegistarPage.setOsnivac("drzava");
		podaciZaRegistarPage.setDatumOsnivanja("11.11.1999");
		podaciZaRegistarPage.setResenjeOosnivanju("43");
		podaciZaRegistarPage.setVlasnickaStruktura("Državna");
		podaciZaRegistarPage.getButtonSave().click();
		
		
			assertEquals(false,modal.getSuccessSaveAlert());
			
			assertTrue(podaciZaRegistarPage.nazivInstitucijeRequiredError().isDisplayed());
			
		
		
	}
	@Test(priority = 24)
	public void podaciZaRegistarPozitiv() {
		podaciZaRegistarPage.tabPodaciZaRegistar().click();
			assertTrue(podaciZaRegistarPage.getbrojAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getButtonSave().isDisplayed());
			assertTrue(podaciZaRegistarPage.getDatumAkreditacije().isDisplayed());
			assertTrue(podaciZaRegistarPage.getOsnivac().isDisplayed());
			assertTrue(podaciZaRegistarPage.getPib().isDisplayed());
		
		podaciZaRegistarPage.setPib("1535251");
		podaciZaRegistarPage.setMaticniBroj("15021988805055");
		podaciZaRegistarPage.setbrojAkreditacije("454");
		podaciZaRegistarPage.setDatumAkreditacije("15.02.2016");
		podaciZaRegistarPage.setNazivInstitucijeAkreditacije("Institut Biologija");
		podaciZaRegistarPage.setNapomenaoRegistru("nema napomene");
		podaciZaRegistarPage.setVrstaInstitucije("Univerzitet");
		podaciZaRegistarPage.setOsnivac("drzava");
		podaciZaRegistarPage.setDatumOsnivanja("11.11.1999");
		podaciZaRegistarPage.setResenjeOosnivanju("43");
		podaciZaRegistarPage.setVlasnickaStruktura("Državna");
		podaciZaRegistarPage.getButtonSave().click();
		
		
			assertEquals(true,modal.getSuccessSaveAlert());
			assertFalse(podaciZaRegistarPage.pibRequiredError().isDisplayed());
			assertFalse(podaciZaRegistarPage.maticniBrojRequiredError().isDisplayed());
			assertFalse(podaciZaRegistarPage.akreditacijaBrojRequiredError().isDisplayed());
			assertFalse(podaciZaRegistarPage.akreditacijaDatumRequiredError().isDisplayed());
			assertFalse(podaciZaRegistarPage.nazivInstitucijeRequiredError().isDisplayed());
			modal.closeSuccessBox();
			
		
		
	}
	

	@Test(priority = 25)
	public void podaciZaProjekteBezParametara() {
		podaciZaProjekte.tabPodaciZaProjekte().click();
			assertTrue(podaciZaProjekte.getButtonCancel().isDisplayed());
			assertTrue(podaciZaProjekte.getButtonSave().isDisplayed());
			assertTrue(podaciZaProjekte.getRacun().isDisplayed());
			assertTrue(podaciZaProjekte.getIDMedjunarodniNivo().isDisplayed());
			assertFalse(podaciZaProjekte.getOblastIstrazivanja().isEnabled());
		
		podaciZaProjekte.setRacun("");
		podaciZaProjekte.setIDMedjunarodniNivo("");
		podaciZaProjekte.setStatusInstitucije("");
		podaciZaProjekte.getButtonSave().click();
		
		
			assertEquals(true,modal.getSuccessSaveAlert());
			assertTrue(podaciZaProjekte.racunRequiredError().isDisplayed());
			assertFalse(podaciZaProjekte.statusInstitucijeRequiredError().isDisplayed());
		
		
		
	}
	
	@Test(priority = 26)
	public void testiranjePatternaZaRacun(){
		podaciZaProjekte.tabPodaciZaProjekte().click();
			assertTrue(podaciZaProjekte.getButtonCancel().isDisplayed());
			assertTrue(podaciZaProjekte.getButtonSave().isDisplayed());
			assertTrue(podaciZaProjekte.getRacun().isDisplayed());
			assertTrue(podaciZaProjekte.getIDMedjunarodniNivo().isDisplayed());
			assertFalse(podaciZaProjekte.getOblastIstrazivanja().isEnabled());
		podaciZaProjekte.setRacun("12-1234567891234-12");
			assertTrue(podaciZaProjekte.racunFormatError().isDisplayed());
		podaciZaProjekte.setRacun("1234-1234567891234-12");
			assertTrue(podaciZaProjekte.racunFormatError().isDisplayed());
		podaciZaProjekte.setRacun("123-123456789123-12");
			assertTrue(podaciZaProjekte.racunFormatError().isDisplayed());
		podaciZaProjekte.setRacun("123-12345678912345-12");
			assertTrue(podaciZaProjekte.racunFormatError().isDisplayed());
		podaciZaProjekte.setRacun("123-1234567891234-1");
			assertTrue(podaciZaProjekte.racunFormatError().isDisplayed());
		podaciZaProjekte.setRacun("123-1234567891234-123");
			assertTrue(podaciZaProjekte.racunFormatError().isDisplayed());
		podaciZaProjekte.setRacun("123-1234567891234-12");
			assertFalse(podaciZaProjekte.racunFormatError().isDisplayed());
		
	}
	

	
	
	@Test(priority = 27)
	public void podaciZaProjektePozitiv() {
		podaciZaProjekte.tabPodaciZaProjekte().click();
			assertTrue(podaciZaProjekte.getButtonCancel().isDisplayed());
			assertTrue(podaciZaProjekte.getButtonSave().isDisplayed());
			assertTrue(podaciZaProjekte.getRacun().isDisplayed());
			assertTrue(podaciZaProjekte.getIDMedjunarodniNivo().isDisplayed());
			assertFalse(podaciZaProjekte.getOblastIstrazivanja().isEnabled());
		
		podaciZaProjekte.setRacun("123-1234567891234-12");
		podaciZaProjekte.setIDMedjunarodniNivo("45365135");
		podaciZaProjekte.setStatusInstitucije("Akreditovan");
		podaciZaProjekte.getButtonSave().click();
		
		
			assertEquals(true,modal.getSuccessSaveAlert());
			assertFalse(podaciZaProjekte.racunRequiredError().isDisplayed());
			assertFalse(podaciZaProjekte.statusInstitucijeRequiredError().isDisplayed());
			modal.closeSuccessBox();
		
		
		
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
