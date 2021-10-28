package flipkart.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import flipkart.base.BaseClass;
import flipkart.pages.FlipkartHomePage;
import flipkart.pages.FlipkartTravelPage;

public class SearchFlightsTest extends BaseClass {

	FlipkartHomePage flipkartHomePage;
	FlipkartTravelPage flipkartTravelPage;
	
	SoftAssert softAssert = new SoftAssert();

	public SearchFlightsTest() {
		super();
	}

	@BeforeClass
	public void applicationLaunch() {
		launchApplication();
	}

	@AfterClass
	public void applicationClose() {
		tearDown();
	}

	@Test(priority = 1)
	public void T11_skipLogin() {
		flipkartHomePage = new FlipkartHomePage();
		boolean isSkipLoginWinodwDisplayed = flipkartHomePage.skipLoginWindow();
		Reporter.log("isSkipLoginWinodwDisplayed >> " + isSkipLoginWinodwDisplayed);
	}
	
	@Test(priority = 2)
	public void T12_gotoTravel() {
		flipkartHomePage.clickOnTravelButton();
	}
	
	@Test(priority = 3)
	public void T13_checkOneWayButtonIsSelected() {
		flipkartTravelPage = new FlipkartTravelPage();
		boolean isOneWaySelected = flipkartTravelPage.checkOneWaySelected();
		softAssert.assertEquals(isOneWaySelected, true);
		Reporter.log("isOneWaySelected >> " + isOneWaySelected);
	}
	
	@Test(priority = 4)
	public void T14_checkRoundTripButton() {
		flipkartTravelPage.clickOnRoundTripRadioButton();
	}
	
	@Parameters("fromCity")
	@Test(priority = 5)
	public void T15_selectFromCity(@Optional("Kolkata") String fromCity) {
		flipkartTravelPage.selectFromCity(fromCity);
	}
	
	@Parameters("toCity")
	@Test(priority = 6)
	public void T16_selectToCity(@Optional("Chennai") String toCity) {
		flipkartTravelPage.selectToCity(toCity);
	}
	
	@Test(priority = 7)
	public void T17_selectFromDate() {
		flipkartTravelPage.selectDepartDate();
	}
	
	@Test(priority = 8)
	public void T18_selectToDate() {
		flipkartTravelPage.selectReturnDate();
	}
	
	@Test(priority = 9)
	public void T19_selectTravellersDetails() {
		flipkartTravelPage.selectAdult();
		flipkartTravelPage.selectChildren();
		flipkartTravelPage.selectEconomyClass();
	}
	
	@Test(priority = 10)
	public void T20_clickOnSerach() {
		flipkartTravelPage.clickOnSearchButton();
	}
	
	@Test(priority = 11)
	public void T21_checkNonStopIsNotSelected() {
		boolean isNonStopSelected = flipkartTravelPage.verifyNonStopIsNotSelected();
		softAssert.assertEquals(isNonStopSelected, true);
		Reporter.log("isNonStopSelected >> " + isNonStopSelected);
	}
	
	@Test(priority = 12)
	public void T22_clickNonStop() {
		flipkartTravelPage.clickNonStopFilter();
	}
	
	@Test(priority = 13)
	public void T23_printAllPrices() {
		flipkartTravelPage.getThePriceList();
	}
	
	@Test(priority = 14)
	public void T24_selectTheLastFlight() {
		flipkartTravelPage.selectLastFlight();
	}
	
	@Test(priority = 15)
	public void T25_clickBookButton() {
		flipkartTravelPage.clickBookButton();
	}
	
	@Test(priority = 16)
	public void T26_orderReview() {
		boolean isOrderReviewSuccess = flipkartTravelPage.orderReview();
		Assert.assertEquals(isOrderReviewSuccess, true);
		Reporter.log("isOrderReviewSuccess >> " + isOrderReviewSuccess);
		softAssert.assertAll();
	}
	
}
