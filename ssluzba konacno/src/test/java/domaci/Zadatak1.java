package domaci;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import global.LoginPage;
import global.MenuPage;
import global.ModalSuccessPage;
import global.VerticalMenuPage;
import helpers.Utils;
import institucije.pages.OsnovniPodaciPage;
import institucije.pages.PodaciZaProjekte;
import institucije.pages.PodaciZaRegistarPage;
import istrazivaci.pages.DodajIstrazivacaPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.studenti.StudentsCreationPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.studenti.StudentsListPage;

@Test
public class Zadatak1 {
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

//	@Test
//	public void osnovniPodaci() {
//		
//		
//		assertTrue(osnovniPodaciPage.getNazivInstitucije().isDisplayed());
//		assertTrue(osnovniPodaciPage.getEmail().isDisplayed());
//		assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8080/#/admin-institution/");
//		
//		osnovniPodaciPage.osnovniPodaciForma("Institut Biologija", "Biology institute", "Srbija", "Novi Sad", "Novi Sad", "nepoznata", "bio.us.rs.un",
//				"biology@gmail.com", "172183483476", "biologijica", "Fakultet tehničkih nauka");
//		
//	}

//	@Test
//	public void podaciZaRegistar(){
//		menuPage.getLanguages().click();
//		menuPage.getLanguagesSerbLat().click();
//		podaciZaRegistarPage.tabPodaciZaRegistar().click();
//		
//		podaciZaRegistarPage.unosPodatakaZaRegistar("1535251", "1502988805555", "454", "15.02.2016", "Institut Biologija", 
//				"", "Fakultet", "", "11.11.1999", "", "Državna");
//		
//		assertTrue(podaciZaRegistarPage.getVlasnickaStruktura().contains("Državna"));
//		
//		
//	}


//public void podaciZaProjekte(){
//	
//	menuPage.getLanguages().click();
//	menuPage.getLanguagesSerbLat().click();
//	podaciZaProjekte.tabPodaciZaProjekte().click();
//	
//	podaciZaProjekte.unosPodataka("123-1234567891234-22", "45365135", "Aktivan");
//	
//	
//}
	@Test(priority=2)
	public void dodajIstrazivaca(){
	
		menuPage.getLanguages().click();
		menuPage.getLanguagesSerbLat().click();
		verticalMenuPage.getIstrazivaciButton().click();
		dodajIstrazivacaPage.getButtonDodajIstarzivaca().click();
			assertTrue(dodajIstrazivacaPage.getDrzavaRodjenja().isDisplayed());
			assertTrue(dodajIstrazivacaPage.getAdresa().isDisplayed());
		dodajIstrazivacaPage.unosIstrazivaca("Nina", "Ninic", "", "", "17.03.2000", "", "", "", "", "", "", "", "Ženski", "155663655354"
			+ "5454354", "", "", "");
			assertEquals(true, modal.getSuccessSaveAlert());
		modal.closeSuccessBox();
	
}
	@Test(priority=3)
	public void logout(){
		
		menuPage.getDropdown().click();
		menuPage.getLogout().click();
		
	}

	@AfterSuite
	public void closeSelenium() {
		driver.quit();
	}

}
