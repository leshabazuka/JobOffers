package org.example.ui;

import org.example.core.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class CommonConditions {
    protected WebDriver driver;

    @BeforeClass()
    public void setUp() {
        driver = Driver.getDriver();
        System.out.println("BeforeClass");
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        Driver.closeDriver();
        System.out.println("AfterClass");
    }
}
