package org.designpattern.com.PageComponents;

import org.designpattern.com.AbstractComponents.AbstractSectionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BottomSection extends AbstractSectionClass {


    By flights = By.cssSelector("[title='Flights']");

    public BottomSection(WebDriver driver, By SectionLocator) {
        super(driver, SectionLocator);
    }

    public void printClassNameOfFlights(){
        System.out.println(findElement(flights).getAttribute("class"));
    }


}
