package org.designpattern.com;

import org.designpattern.com.AbstractComponents.TripTypeStrategyFactor;
import org.designpattern.com.PageObjects.TravelHomePage;
import org.designpattern.com.TestData.JsonExtracter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlightAvailabilityDemo extends BaseTest{

    TravelHomePage th;
    TripTypeStrategyFactor obj;

    @Test(dataProvider = "flightDetails")
    public void testCheckAvailability(HashMap<String,String> cityDetails) throws InterruptedException {
        th = new TravelHomePage(driver);
        //obj = th.selectTripType("roundTrip");
        //obj.checkAvailability(cityValue);
        obj = th.selectTripType("multicity");
        obj.checkAvailability(cityDetails);
    }

    @DataProvider
    public Object[][] flightDetails() throws IOException {

        JsonExtracter js = new JsonExtracter();
        List<HashMap<String , String>> mapList = js.extractData(System.getProperty("user.dir")+"//src//main//java//org//designpattern//com//TestData//CityDetails.json");
        System.out.println(mapList.get(0).toString());
        System.out.println(mapList.get(1).toString());

        return new Object[][]{
                {
                    mapList.get(0)
                },{
                    mapList.get(1)
                }
        };
    }
}
