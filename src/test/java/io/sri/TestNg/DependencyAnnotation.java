package io.sri.TestNg;

import org.testng.annotations.Test;

public class DependencyAnnotation {

    @Test
    public void OpeningBrowser()
    {
        System.out.println("Executing Opening Browser");
    }

    @Test(dependsOnMethods = ("OpeningBrowser"),alwaysRun = true)
    public void FlightBooking()
    {
        System.out.println("Executing FlightBooking ...");
    }

    @Test(enabled = false) //if enable is set to false , it will not include the execution
    public void payment()
    {
        System.out.println("New TestCases");
    }

    @Test(timeOut = 45000)
    public void Timerelated()
    {
        System.out.println("New Testcase for TimeRelated ");
    }
}
