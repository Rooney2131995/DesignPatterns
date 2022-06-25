package org.designpattern.com.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.designpattern.com.AbstractComponents.TripTypeStrategyFactor;
import org.designpattern.com.PageComponents.BottomSection;
import org.designpattern.com.PageComponents.HeaderSection;
import org.designpattern.com.PageComponents.MultiCity;
import org.designpattern.com.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TravelHomePage {

By HeaderSectionLocator = By.className("search-buttons-heading");
By FooterSectionLocator = By.id("traveller-home");
By TripTypeSection = By.id("flightSearchContainer");
WebDriver driver;

    private TripTypeStrategyFactor tripTypeStrategy;

    public TravelHomePage(WebDriver driver){
        this.driver = driver;
    }

    public HeaderSection getHeaderSection() {
        return new HeaderSection(driver, HeaderSectionLocator);
    }

    public BottomSection getFooterSection() {
        return new BottomSection(driver, FooterSectionLocator);
    }

    public TripTypeStrategyFactor selectTripType(String tripType) {
        if(tripType=="roundTrip"){
            return new RoundTrip(driver, TripTypeSection);
        }else if(tripType == "multicity"){
            return new MultiCity(driver, TripTypeSection);
        }
        return null;
    }

}
