package org.designpattern.com.PageComponents;

import org.designpattern.com.AbstractComponents.AbstractSectionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderSection extends AbstractSectionClass {

    By flights = By.xpath("//a[@title=\"Flights\"]");


    public HeaderSection(WebDriver driver, By SectionLocator) {
        super(driver, SectionLocator);
    }

    public void printClassNameOfFlights(){
        System.out.println(findElement(flights).getAttribute("class"));
    }

    public void prinTMessage(){
        System.out.println("Hello");
    }





}
