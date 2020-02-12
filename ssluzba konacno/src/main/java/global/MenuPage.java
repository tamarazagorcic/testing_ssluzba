package global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.Utils;

public class MenuPage {
	private WebDriver driver;

	public MenuPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	
	public WebElement getMenyIcon() {
		return Utils.waitToBeClickable(driver, By.xpath("//span [contains(text(), 'Toggle navigation')]"), 10);
	}
	
	
	public WebElement getLanguages() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id='main-page']/header/nav/div/ul[1]/div/button/span[1]/img"), 10);
	}
	public WebElement getLanguagesSerbLat() {
		return Utils.waitToBeClickable(driver, By.xpath("//a [@translate='BUTTON_LANG_SR_LAT']"), 10);
	}
	public WebElement getLanguagesSerbCir() {
		return Utils.waitToBeClickable(driver, By.xpath("//a [@translate='BUTTON_LANG_SR_CYR']"), 10);
	}
	public WebElement getLanguagesEng() {
		return Utils.waitToBeClickable(driver, By.xpath("//a [@translate='BUTTON_LANG_EN']"), 10);
	}

	
	public WebElement getDropdown() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id='main-page']/header/nav/div/ul[2]/li"), 10);
	}
	
	
	
	
	

	public WebElement getLogout() {
		return Utils.waitToBeClickable(driver, By.xpath("//span [@translate='LOGOUT']"), 10);
	}

	

}
