package com.juaracoding.appium.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Calculator {

	private AndroidDriver<MobileElement> driver;
	
	public Calculator(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	//Locator
	By btnSatu = By.id("com.sec.android.app.popupcalculator:id/bt_01");
	By btnDua = By.id("com.sec.android.app.popupcalculator:id/bt_02");
	By btnTiga = By.id("com.sec.android.app.popupcalculator:id/bt_03");
	By btnEmpat = By.id("com.sec.android.app.popupcalculator:id/bt_04");
	By btnTambah = By.id("com.sec.android.app.popupcalculator:id/bt_add");
	By btnKurang = By.id("com.sec.android.app.popupcalculator:id/bt_sub");
	By btnKali = By.id("com.sec.android.app.popupcalculator:id/bt_mul");
	By btnBagi = By.id("com.sec.android.app.popupcalculator:id/bt_div");
	By btnSamaDengan = By.id("com.sec.android.app.popupcalculator:id/bt_equal");
	By hasil = By.id("com.sec.android.app.popupcalculator:id/txtCalc");
	/* web xpath = //taghtml[contains(@attr, value)] */
	
	//method
	public void calcTambah() {
		driver.findElement(btnSatu).click();
		driver.findElement(btnTambah).click();
		driver.findElement(btnDua).click();
		driver.findElement(btnSamaDengan).click();
	}
	
	public void calcKurang() {
		driver.findElement(btnEmpat).click();
		driver.findElement(btnKurang).click();
		driver.findElement(btnTiga).click();
		driver.findElement(btnSamaDengan).click();
	}
	
	public void calcKali() {
		driver.findElement(btnTiga).click();
		driver.findElement(btnKali).click();
		driver.findElement(btnDua).click();
		driver.findElement(btnSamaDengan).click();
	}
	
	public void calcBagi() {
		driver.findElement(btnEmpat).click();
		driver.findElement(btnBagi).click();
		driver.findElement(btnDua).click();
		driver.findElement(btnSamaDengan).click();
	}
	
	
	//public String getResult
	public String getTxtResult() {
		return driver.findElement(hasil).getText();
	}
}
