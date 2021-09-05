package Automation;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCases {

        BasePage basePage;
        LoginPage loginPage;
        HomePage homePage;
        public WebDriver driver;

        @BeforeTest
        public void tearup() throws IOException {
            driver = SetUp.initiateDriver();
            basePage = new BasePage(driver);
            loginPage = new LoginPage(driver);
            homePage = new HomePage(driver);
        }

        @BeforeMethod
        public void getUrl() {
            driver.get(SetUp.properties.getProperty("url"));
            driver.manage().window().maximize();
            SetUp.holdExcution(10);
        }

        @AfterTest
        public void tearnDown() {
            driver.quit();
        }

    @Test(priority = 2)
        public void verifyLogo() {
            basePage.logoenabled();
        }

        @Test(priority = 1)
        public void verifyCurrencyDropdown() {
            basePage.setCurrencydropdown();
        }

        @Test(priority = 12)
        public void verifySignup() {
            basePage.clickSignup();
        }

        @Test(priority = 13)
        public void verifySignIn() {
            basePage.clickSignIn();
            SetUp.holdExcution(3);
            loginPage.enterusername(SetUp.properties.getProperty("username"));
            loginPage.enterpassword(SetUp.properties.getProperty("password"));

            SetUp.holdExcution(3);
            loginPage.signIn();
            SetUp.holdExcution(3);

        }

        @Test(priority = 3)
        public void verifyComanyDropdown() {
            basePage.clickCompnay();
        }

        @Test(priority = 4)
        public void verifyAboutUs() {
            basePage.aboutbutton();
        }

        @Test(priority = 5)
        public void verifyTermsofUse() {
            basePage.termsOfUsebutton();
        }

        @Test(priority = 6)
        public void verifyfaq() {
            basePage.faqButton();
        }

        @Test(priority = 7)
        public void verifyMenubutton() {
            homePage.clickhomebutton();
            SetUp.holdExcution(5);
            homePage.clickflightbutton();
            SetUp.holdExcution(5);
            homePage.clicktoursbutton();
            SetUp.holdExcution(5);
            homePage.clickVisabutton();
            SetUp.holdExcution(5);
            homePage.clickhotelsbutton();
        }


        @Test(priority = 8)
        public void verifyHotelSearch() {
            homePage.hotelSearch();
        }

        @Test(priority = 9)
        public void verifyTourSearch() {
            homePage.tourSearch();
        }
    }

