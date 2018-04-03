package io.sri.TestNg;

import org.testng.annotations.*;

public class testNGExample2 {

    @BeforeMethod
    public void UseridGeneration()
    {
        System.out.println("Userid Generation");
    }

    @BeforeTest
    public void BCookiesclose()
    {
        System.out.println("Deleting cookies Before completing all the test ..");
    }

    @AfterTest
    public void Cookiesclose()
    {
        System.out.println("Deleting cookies after completing all the test ..");
    }

    @Test
    public void AOpeningBrowser()
    {
        //This open the Browser
        System.out.println("Opening Browser ...");
    }

    @AfterMethod
    public void AfterMethod()
    {
        System.out.println("Run of the AfterMethod ......");
    }

    @Test
    public void FlightBooking()
    {
        System.out.println("Flight Booking ...");
    }

}
