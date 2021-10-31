package flipkart.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import flipkart.base.BaseClass;

public class FlipkartHomePage extends BaseClass {
	
	@FindBy(xpath = "//html/body/div[2]/div/div/button")
	List <WebElement> loginPopupBoxCloseButton;
	
	@FindBy(xpath = "//*[@id='container']/div/div[1]/div/div/div[2]//*[name()='svg']")
	WebElement travelImageOnHeader;
	
	@FindBy(xpath = "//div[contains(text(),'Travel')]")
	WebElement travelButton;
	
	public FlipkartHomePage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, waitUnit);
	}
	
	public boolean skipLoginWindow() {
		boolean isSkipLoginWinodwDisplayed = false;
		wait.until(ExpectedConditions.visibilityOfAllElements(loginPopupBoxCloseButton));
		if(loginPopupBoxCloseButton.size()>0) {
			loginPopupBoxCloseButton.get(0).click();
			isSkipLoginWinodwDisplayed = true;
		}
		return isSkipLoginWinodwDisplayed;
	}

	public void clickOnTravelButton() {
		wait.until(ExpectedConditions.elementToBeClickable(travelButton)).click();
	}

}
