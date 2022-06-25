package org.designpattern.com;

import org.designpattern.com.PageObjects.TravelHomePage;
import org.testng.annotations.Test;

public class HeaderAndFooterTest extends BaseTest{

    TravelHomePage obj;

    @Test
    public void TestHeader(){

        obj = new TravelHomePage(driver);
        obj.getHeaderSection().printClassNameOfFlights();
    }

    @Test
    public void TestFooter(){
        obj = new TravelHomePage(driver);
        obj.getFooterSection().printClassNameOfFlights();
    }

}
