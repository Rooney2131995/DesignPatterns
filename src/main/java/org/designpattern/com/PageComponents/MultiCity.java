package org.designpattern.com.PageComponents;

import org.designpattern.com.AbstractComponents.AbstractSectionClass;
import org.designpattern.com.AbstractComponents.TripTypeStrategyFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class MultiCity extends AbstractSectionClass implements TripTypeStrategyFactor {


    WebDriver driver;
    WebElement section;
    By MultiCityCheckBox = By.id("ctl00_mainContent_rbtnl_Trip_2");
    By From = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    By To = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    By SearchButton = By.id("ctl00_mainContent_btn_FindFlights");
    By MultiCityAlertOkButton = By.id("MultiCityModelAlert");
    By From2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    By To2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    By seniorCitizen = By.id("ctl00_mainContent_chk_SeniorCitizenDiscount");


    public MultiCity(WebDriver driver, By section) {
        super(driver, section);
        this.driver = driver;
        this.section = driver.findElement(section);
    }

    @Override
    public void checkAvailability(HashMap<String, String> citySelecion) {
        goToMultiCitySelection(s->selectFromCity(citySelecion.get("From1")));
        selectToCity(citySelecion.get("To1"));
        selectFrom2City(citySelecion.get("From2"));
        selectTo2City(citySelecion.get("To2"));
        driver.findElement(seniorCitizen).click();
        driver.findElement(SearchButton).click();
    }

    private void goToMultiCitySelection(Consumer<MultiCity> consumer){
        driver.findElement(MultiCityCheckBox).click();
        driver.findElement(MultiCityAlertOkButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(MultiCityAlertOkButton));
        consumer.accept(this);
    }

    private void selectFromCity(String from) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        findElement(From).click();
        findElement(By.xpath("//a[@value=\""+from+"\"]")).click();
    }

    private void selectToCity(String to) {
        //findElement(To).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@value=\""+to+"\"])[2]")));
        findElement(By.xpath("(//a[@value=\""+to+"\"])[2]")).click();

    }

    private void selectFrom2City(String from) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        findElement(From2).click();
        findElement(By.xpath("(//a[@value=\""+from+"\"])[3]")).click();
    }

    private void selectTo2City(String to) {
        //findElement(To2).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@value=\""+to+"\"])[4]")));
        findElement(By.xpath("(//a[@value=\""+to+"\"])[4]")).click();
    }

}
