package io.sri.TestNg;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGExample {

  @BeforeMethod
  public void UseridGenerate()
  {
      System.out.println("Userid Generation");
      //It will run every time before test method
  }

    @BeforeTest
    public void Cookies()
    {
        System.out.println("Delete the Cookies before test");
        //delete cookies

    }


    @Test
    public void openBrowser()
    {
        System.out.println("Openning Browser ....");
    }

    @Test
    public void FlightBooking()
    {
        System.out.println("Flight Booking");
    }

    @Test
    public void closeBrowser()
    {
        System.out.println("Closing Browser ....");
    }



    @AfterTest
    public void Cookiesclose()
    {
        System.out.println("Delete the Cookies after test");
        //closeBroswer

    }


}
