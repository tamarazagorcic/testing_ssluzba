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
import istrazivaci.pages.DodajIstrazivacaPage;
import istrazivaci.pages.IstrazivaciListPage;
import istrazivaci.pages.PodaciZaProjekteIstrazivaci;
import istrazivaci.pages.PodaciZaRegistarIstrazivaci;

public class loginTest {

	
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
		
	}
	@Test(priority=1)
	public void loginBezParametara() {
		assertTrue(loginPage.pocetnaProvera().isDisplayed());
		assertTrue(loginPage.getUsername().isDisplayed());
		
		loginPage.setUsername("fdfgzdgf");
		loginPage.getUsername().clear();
		loginPage.setPassword("zdfgdzg");
		loginPage.getPassword().clear();
		assertTrue(loginPage.getOdustaniBtn().isDisplayed());
		assertTrue(loginPage.getPrijaviSeBtn().isDisplayed());
		assertFalse(loginPage.getPrijaviSeBtn().isEnabled());
		assertTrue(loginPage.usernameRequiredError().isDisplayed());
		assertEquals(loginPage.passwordRequiredError().isDisplayed(),true);
		
		
	}
	@Test(priority=2)
	public void loginBezUsername() {
		assertTrue(loginPage.pocetnaProvera().isDisplayed());
		assertTrue(loginPage.getUsername().isDisplayed());
		

		loginPage.setUsername("fdfgzdgf");
		loginPage.getUsername().clear();
		loginPage.setPassword("zdfgdzg");
		
		assertTrue(loginPage.getOdustaniBtn().isDisplayed());
		assertTrue(loginPage.getPrijaviSeBtn().isDisplayed());
		assertFalse(loginPage.getPrijaviSeBtn().isEnabled());
		assertTrue(loginPage.usernameRequiredError().isDisplayed());
		assertEquals(loginPage.passwordRequiredError().isDisplayed(),false);
		
		
	}
	
	@Test(priority=3)
	public void loginBezPassword() {
		assertTrue(loginPage.pocetnaProvera().isDisplayed());
		assertTrue(loginPage.getUsername().isDisplayed());
		

		loginPage.setUsername("fdfgzdgf");
		
		loginPage.setPassword("zdfgdzg");
		loginPage.getPassword().clear();
		assertTrue(loginPage.getOdustaniBtn().isDisplayed());
		assertTrue(loginPage.getPrijaviSeBtn().isDisplayed());
		assertFalse(loginPage.getPrijaviSeBtn().isEnabled());
		assertFalse(loginPage.usernameRequiredError().isDisplayed());
		assertEquals(loginPage.passwordRequiredError().isDisplayed(),true);
		
		
	}
	
	@Test(priority=4)
	public void loginSaPogresnimUsername() {
		assertTrue(loginPage.pocetnaProvera().isDisplayed());
		assertTrue(loginPage.getUsername().isDisplayed());
		
		loginPage.login("djura@djuraminis", "adminvinca");
		assertTrue(loginPage.getOdustaniBtn().isDisplayed());
		assertTrue(loginPage.getPrijaviSeBtn().isDisplayed());
		assertTrue(loginPage.getPrijaviSeBtn().isEnabled());
		assertTrue(loginPage.errorInLogin().isDisplayed());
		
	}
	@Test(priority=5)
	public void loginSaPogresnimPassword() {
		assertTrue(loginPage.pocetnaProvera().isDisplayed());
		assertTrue(loginPage.getUsername().isDisplayed());
		
		loginPage.login("djura@djuraminis.com", "admin");
		assertTrue(loginPage.getOdustaniBtn().isDisplayed());
		assertTrue(loginPage.getPrijaviSeBtn().isDisplayed());
		assertTrue(loginPage.getPrijaviSeBtn().isEnabled());
		assertTrue(loginPage.errorInLogin().isDisplayed());
		
		
	}
	
	
	@Test(priority=6)
	public void login() {
		assertTrue(loginPage.pocetnaProvera().isDisplayed());
		assertTrue(loginPage.getUsername().isDisplayed());
		
		loginPage.login("djura@djuraminis.com", "adminvinca");
		assertTrue(menuPage.getMenyIcon().isDisplayed());
		assertEquals(osnovniPodaciPage.getFormBecground().isDisplayed(),true);
		
		
	}
	
	@AfterSuite
	public void closeSelenium() {
		driver.quit();
	}
}
