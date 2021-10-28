package flipkart.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import flipkart.base.BaseClass;

public class FlipkartTravelPage extends BaseClass{

	@FindBy(xpath  = "//*[@for='ONE_WAY']//div[2]/div")
	WebElement oneWayRadioButton;
	
	@FindBy(xpath  = "//*[@for='ROUND_TRIP']/div[1]")
	WebElement roundTripRadioButton;
	
	@FindBy(xpath  = "//*[@name='0-departcity']")
	WebElement fromInputBox;
	
	@FindBy(xpath  = "//*[@id='container']//div[1]//form//div[2]//*[text()='Kolkata']")
	WebElement selectKolkata;
	
	@FindBy(xpath  = "//*[@name='0-arrivalcity']")
	WebElement toInputBox;
	
	@FindBy(xpath  = "(//*[@id='container']//div[1]//form//div[2]//*[text()='Chennai'])[2]")
	WebElement selectChennai;
	
	@FindBy(xpath  = "//*[@name='0-datefrom']")
	WebElement departDateBox;
	
	@FindBy(xpath  = "//*[@id='container']//div[1]//form/div/div[3]//table[2]/tbody//*[text()='1']")
	WebElement fromDate;
	
	@FindBy(xpath  = "//*[@name='0-dateto']")
	WebElement returnDateBox;
	
	@FindBy(xpath  = "//*[@id='container']//div[1]//form/div/div[3]//table[2]/tbody//*[text()='30']")
	WebElement toDate;
	
	@FindBy(xpath  = "//*[@name='0-travellerclasscount']")
	WebElement travellersBox;
	
	@FindBy(xpath  = "//*[@id='container']//form//div[1]/div[2]/div/div[3]/button")
	WebElement adultIncreaseButton;
	
	@FindBy(xpath  = "//*[@id='container']//form//div[2]/div[2]/div/div[3]/button")
	WebElement childrenIncreaseButton;
	
	@FindBy(xpath  = "//*[@id='container']//form//*[text()='Economy']")
	WebElement ecomomyRadioButton;
	
	@FindBy(xpath  = "//*[@id='container']//form//div[3]//div[2]/button")
	WebElement doneButton;
	
	@FindBy(xpath  = "//*[@id='container']//form//button")
	WebElement searchButton;
	
	@FindBy(xpath  = "//*[@class='non-stop']/span[2]/span")
	WebElement nonStopFliterOption;
	
	@FindBy(xpath  = "//*[@class='flight-listing-page']//div[3]/div[1]/div/div//*[@class='price']/div")
	List <WebElement> priceList1;
	
	@FindBy(xpath  = "//*[@class='flight-listing-page']/div[1]/div[2]/div[2]/div[3]/div[2]//*[@class='price']/div")
	List <WebElement> priceList2;
	
	@FindBy(xpath  = "//*[@class='flight-listing-page']/div[1]//div[3]/div[1]/div//div[1]//*[@class='radio-button']")
	List <WebElement> selectLastFlight;
	
	@FindBy(xpath  = "//*[@class='book-cta']/button")
	WebElement bookButton;
	
	@FindBy(xpath  = "//span[normalize-space()='CONTINUE']")
	WebElement orderReviewContiuneButton;
	
	
	public FlipkartTravelPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, waitUnit);
	}
	
	public boolean checkOneWaySelected() {
		boolean isOneWaySelectedDefault = false;
		String isChecked = wait.until(ExpectedConditions.visibilityOf(oneWayRadioButton)).getAttribute("data-checked");
		if(isChecked.equalsIgnoreCase("true")) {
			isOneWaySelectedDefault = true;
		}
		return isOneWaySelectedDefault;
	}
	
	public void clickOnRoundTripRadioButton() {
		wait.until(ExpectedConditions.elementToBeClickable(roundTripRadioButton)).click();
	}
	
	public void selectFromCity(String fromCity) {
		wait.until(ExpectedConditions.elementToBeClickable(fromInputBox)).sendKeys(fromCity);
		wait.until(ExpectedConditions.visibilityOf(selectKolkata));
		wait.until(ExpectedConditions.elementToBeClickable(selectKolkata)).click();
	}
	
	public void selectToCity(String toCity) {
		wait.until(ExpectedConditions.elementToBeClickable(toInputBox)).sendKeys(toCity);
		wait.until(ExpectedConditions.visibilityOf(selectChennai));
		wait.until(ExpectedConditions.elementToBeClickable(selectChennai)).click();
	}
	
	public void selectDepartDate() {
		wait.until(ExpectedConditions.elementToBeClickable(departDateBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(fromDate)).click();
	}
	
	public void selectReturnDate() {
		wait.until(ExpectedConditions.elementToBeClickable(returnDateBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(toDate)).click();
	}
	
	public void selectAdult() {
		wait.until(ExpectedConditions.elementToBeClickable(travellersBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(adultIncreaseButton)).click();
	}
	
	public void selectChildren() {
		wait.until(ExpectedConditions.elementToBeClickable(childrenIncreaseButton)).click();
	}
	
	public void selectEconomyClass() {
		wait.until(ExpectedConditions.elementToBeClickable(ecomomyRadioButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(doneButton)).click();
	}
	
	public void clickOnSearchButton() {
		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	}
	
	public boolean verifyNonStopIsNotSelected() {
		boolean isNonStopIsSelected = false;
		wait.until(ExpectedConditions.elementToBeClickable(nonStopFliterOption));
		String nonStopButton = nonStopFliterOption.getAttribute("class");
		if(nonStopButton.contains("switch-off")) {
			isNonStopIsSelected = true;
		}
		return isNonStopIsSelected;
	}
	
	public void clickNonStopFilter() {
		wait.until(ExpectedConditions.elementToBeClickable(nonStopFliterOption)).click();
	}
	
	public void getThePriceList() {
		wait.until(ExpectedConditions.visibilityOfAllElements(priceList1));
		wait.until(ExpectedConditions.visibilityOfAllElements(priceList2));
		int lastFilghtPrice = priceList1.size()-1;
		scrollToView(selectLastFlight.get(lastFilghtPrice));
		System.out.println("____________________________________________");
		System.out.println("Number of flights from Kolkata -> Chennai : "+ priceList1.size());
		System.out.println("");
		for (int a = 0; a < priceList1.size(); a++) {
			System.out.println("Kolkata -> Chennai : " + priceList1.get(a).getText());
		}
		System.out.println("____________________________________________");
		System.out.println("Number of flights from Chennai -> Kolkata : "+ priceList2.size());
		System.out.println("");
		for (int a = 0; a < priceList2.size(); a++) {
			System.out.println("Chennai -> Kolkata : " + priceList2.get(a).getText());
		}
		System.out.println("____________________________________________");
	}
	
	public void selectLastFlight() {
		wait.until(ExpectedConditions.visibilityOfAllElements(selectLastFlight));
		int lastBeforeFilght = selectLastFlight.size()-2;
		int lastFilght = selectLastFlight.size()-1;
		scrollToView(selectLastFlight.get(lastBeforeFilght));
		wait.until(ExpectedConditions.elementToBeClickable(selectLastFlight.get(lastFilght)));
		selectLastFlight.get(lastFilght).click();
	}
	
	public void clickBookButton() {
		wait.until(ExpectedConditions.elementToBeClickable(bookButton)).click();
	}
	
	public boolean orderReview() {
		boolean isOrderReviewPageDisplayed = false;
		wait.until(ExpectedConditions.elementToBeClickable(orderReviewContiuneButton));
		if (driver.getTitle().contains("Review Store Online")) {
			isOrderReviewPageDisplayed = true;
		}
		return isOrderReviewPageDisplayed;
	}
}
