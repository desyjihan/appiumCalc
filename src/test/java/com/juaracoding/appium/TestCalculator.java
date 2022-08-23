package com.juaracoding.appium;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.appium.pages.Calculator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestCalculator {
	
	private static AndroidDriver<MobileElement> driver;
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium:deviceName", "SM-A500F");
		capabilities.setCapability("appium:uuid", "6d41faf3");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appium:platformVersion", "6.0.1");
		capabilities.setCapability("appium:appPackage", "com.sec.android.app.popupcalculator");
		capabilities.setCapability("appium:appActivity", "com.sec.android.app.popupcalculator.Calculator");
		capabilities.setCapability("appium:appWaitDuration", "60000");
		capabilities.setCapability("appium:adbExecTimeout", "60000");
		capabilities.setCapability("appium:automationName", "UiAutomator1");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); 
	}
	
	@BeforeMethod
	public void pageObject() {
		calculator = new Calculator(driver);
	}
	
	@Test
	public void testTambah() {
		try {
			Thread.sleep(3000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		calculator.calcTambah();
		System.out.println("Hasil ="+calculator.getTxtResult());
		Assert.assertTrue(calculator.getTxtResult().contains ("3"));
	}
	
	@Test
	public void testKurang() {
		calculator.calcKurang();
		System.out.println("Hasil = "+calculator.getTxtResult());
		Assert.assertTrue(calculator.getTxtResult().contains ("1"));
		
	}
	
	@Test
	public void testKali() {
		calculator.calcKali();
		System.out.println("Hasil = "+calculator.getTxtResult());
		Assert.assertTrue(calculator.getTxtResult().contains ("6"));
	}
	
	@Test
	public void testBagi() {
		calculator.calcBagi();
		System.out.println("Hasil = "+calculator.getTxtResult());
		Assert.assertTrue(calculator.getTxtResult().contains ("2"));
	}
	
	@AfterClass
	public void closeApp() {
		driver.quit();
	}
}
