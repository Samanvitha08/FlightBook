package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;

public class ValidationTest extends BaseTest {

    @Test
    public void testEmptyNameValidation() {

        HomePage homePage = new HomePage(driver);
        homePage.searchFlight("Boston", "London");

        FlightListPage flightListPage = new FlightListPage(driver);
        flightListPage.selectFirstFlight();

        PurchasePage purchasePage = new PurchasePage(driver);

        purchasePage.completePurchase(
                "",
                "MG Road",
                "Vijayawada",
                "Andhra Pradesh",
                "520001",
                "123456",
                "11",
                "2026",
                "Samanvitha"
        );

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        Assert.assertTrue(confirmationPage.getConfirmationMessage().contains("Thank you"));
    }
}