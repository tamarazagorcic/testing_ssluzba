package global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.Utils;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public WebElement pocetnaProvera() {
		return Utils.waitForElementPresence(driver, By.xpath("//p [contains(text(), 'Prijavite se da počnete sa radom.')]"), 15);
	}
	
	

	public WebElement getUsername() {
		return Utils.waitForElementPresence(driver, By.id("username"), 10);
	}

	public void setUsername(String username) {
		WebElement usernameInput = getUsername();
		usernameInput.clear();
		usernameInput.sendKeys(username);
	}
	
	public WebElement usernameRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span [contains(text(), 'Korisničko ime obavezno')]"), 15);
	}
	

	public WebElement getPassword() {
		return Utils.waitForElementPresence(driver, By.id("password"), 10);
	}
	public void setPassword(String password) {
		WebElement passwordInput = getPassword();
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	public WebElement passwordRequiredError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span [contains(text(), 'Lozinka obavezna')]"), 15);
	}
	
	
	public WebElement errorInLogin() {
		return Utils.waitForElementPresence(driver, By.xpath("//li [contains(text(), 'Pogrešno korisničko ime ili lozinka!')]"), 15);
	}
	public WebElement errorInLogin2() {
		return Utils.waitForElementPresence(driver, By.xpath("//li [contains(text(), 'Problem sa logovanjem')]"), 15);
	}
	
	 

	public WebElement getPrijaviSeBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[@type='submit']"), 10);
	}

	public WebElement getOdustaniBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[@type='button']"), 10);
	}
	

	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
		getPrijaviSeBtn().click();
	}

}
