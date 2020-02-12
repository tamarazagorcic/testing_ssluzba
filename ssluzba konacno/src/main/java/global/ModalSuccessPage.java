package global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import helpers.Utils;

public class ModalSuccessPage {
	private WebDriver driver;

	public ModalSuccessPage(WebDriver driver) {
		this.driver = driver;
	}

	
		public boolean getSuccessSaveAlert() {
			return Utils.isPresent(driver,  ( By.xpath("//div [contains(@class='ui-pnotify ')]")));
		}
		public WebElement getSuccessAlert() {
			return Utils.waitForElementPresence(driver, (By.cssSelector("div.alert-success")),10);
		}

		
		public void closeSuccessBox(){
			WebElement alert = driver.findElement(By.cssSelector("div.alert-success"));
			Actions akcija = new Actions(driver);
			akcija.moveToElement(alert).build().perform();
			driver.findElement(By.xpath("//span[@class='fa fa-times']")).click();
		}
	 
		public WebElement getSuccessTitle() {
			return Utils.waitForElementPresence(driver, (By.xpath("//div [@class='ui-pnotify-title']")), 20);
		}
		public boolean getErrorAlert(){
			return Utils.isPresent(driver, (By.cssSelector("div.alert-danger']")));
		
		}

}
