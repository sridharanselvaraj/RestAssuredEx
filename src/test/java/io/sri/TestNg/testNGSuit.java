package io.sri.TestNg;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class testNGSuit {

    @BeforeSuite
    public void installSoftware()
    {
        System.out.println("I am the First Case ......");
    }

    @AfterSuite
    public void  uninstallSoftware()
    {
        System.out.println("Uninstalled Software ...........");
    }
}
