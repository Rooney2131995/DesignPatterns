package org.designpattern.com.PageComponents;

import org.designpattern.com.AbstractComponents.AbstractSectionClass;
import org.designpattern.com.AbstractComponents.TripTypeStrategyFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.function.Consumer;

import static java.lang.Thread.sleep;

public class RoundTrip extends AbstractSectionClass implements TripTypeStrategyFactor {

    WebDriver driver;
    WebElement section;
    By RoundTripCheckBox = By.id("ctl00_mainContent_rbtnl_Trip_1");
    By From = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    By To = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    By SearchButton = By.id("ctl00_mainContent_btn_FindFlights");
    By seniorCitizen = By.id("ctl00_mainContent_chk_SeniorCitizenDiscount");

    public RoundTrip(WebDriver driver, By section) {
        super(driver, section);
        this.driver = driver;
        this.section = driver.findElement(section);
    }


    @Override
    public void checkAvailability(HashMap<String, String> citySelction) {
        goToRoundCitySelection(s->selectFromCity(citySelction.get("From1")));
        selectToCity(citySelction.get("To1"));
        driver.findElement(seniorCitizen).click();
        driver.findElement(SearchButton).click();
    }

    public void goToRoundCitySelection(Consumer <RoundTrip> consumer){
        driver.findElement(RoundTripCheckBox).click();
        consumer.accept(this);
    }

    private void selectFromCity(String from) {
        findElement(From).click();
        findElement(By.xpath("//a[@value=\""+from+"\"]")).click();
    }

    private void selectToCity(String to) {
        //findElement(To).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@value=\""+to+"\"])[2]")));
        findElement(By.xpath("(//a[@value=\""+to+"\"])[2]")).click();
    }
}
