package com.exercisel.step_definitions;

import com.exercisel.utilities.ConfigurationReader;
import com.exercisel.utilities.Driver;
import cucumber.api.java.After;
import org.junit.Before;
import java.util.concurrent.TimeUnit;

public class Hook {
    @Before
    public void setUp() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
