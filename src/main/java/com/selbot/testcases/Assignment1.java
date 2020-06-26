package com.selbot.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Assignment1 {
	
	@Test
	public void newPatient() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		DesiredCapabilities cap = new DesiredCapabilities().firefox();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, 
		   org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT);
		FirefoxDriver dr = new FirefoxDriver(cap);
		dr.get("https://demo.openemr.io/b/openemr/index.php");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.findElementById("authUser").sendKeys("admin");
		dr.findElementById("clearPass").sendKeys("pass");
		new Select(dr.findElementByXPath("//select[@class='form-control']")).selectByVisibleText("English (Indian)");
		dr.findElementByXPath("//button[@type='submit']").click();
		new Actions(dr).moveToElement(dr.findElementByXPath("//div[text()='Patient/Client']"))
		.click(dr.findElementByXPath("//div[text()='New/Search']")).build().perform();
		dr.switchTo().frame(dr.findElementByXPath("//iframe[@name='pat']"));
		dr.findElementById("form_fname").sendKeys("Ram");
		dr.findElementById("form_lname").sendKeys("Leela1");
		dr.findElementById("form_DOB").sendKeys("2019-01-20");
		new Select(dr.findElementById("form_sex")).selectByVisibleText("Male");
		dr.findElementById("create").click();
		dr.switchTo().defaultContent();
		dr.switchTo().frame(dr.findElementById("modalframe"));
		dr.findElementByXPath("//input[@value='Confirm Create New Patient']").click();
		dr.switchTo().defaultContent();
		Thread.sleep(2000);
		//dr.switchTo().alert().accept();
		dr.findElementByXPath("//div[text()='Recall Board']").click();
		dr.switchTo().frame(dr.findElementByXPath("//iframe[@name='rcb']"));
		dr.findElementByXPath("//button[text()='New Recall']").click();



	}

}
