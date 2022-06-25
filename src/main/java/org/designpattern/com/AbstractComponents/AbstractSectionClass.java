package org.designpattern.com.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractSectionClass {

    WebElement element;
    WebDriver driver;

    public AbstractSectionClass(WebDriver driver, By SectionLocator){
        this.driver = driver;
        this.element = driver.findElement(SectionLocator);
    }

    public WebElement findElement(By locator){
        System.out.println(element.toString());
        return element.findElement(locator);
    }

}
