package com.koltiva.stepdef.test;

import com.koltiva.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import utils.PropertyManager;

import java.io.IOException;
import java.util.Properties;

public class Test {
    private Properties props = new PropertyManager().getPropsDemo();

    private AndroidDriver<AndroidElement> driver;

    public Test() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @Given("the user open the app")
    public void test(){
        System.out.println("the users open the app");
    }
}
