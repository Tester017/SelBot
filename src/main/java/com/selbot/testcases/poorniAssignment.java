package com.selbot.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class poorniAssignment {
	
	public FirefoxDriver dr;
	
	@Test
	public void openCalander() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		dr = new FirefoxDriver();
		dr.get("https://team-scale.com/testo/references/date_picker/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.findElementByXPath("//input[@value='Open calendar']").click();
		//calender("22.10.2020"); // date formate should be dd.mm.yyyy
		Thread.sleep(5000);
		dr.close();
	}

	public void calender(String date)
	{
		String month = null;
		String nDate= date.substring(0,2);
		String nMonth = date.substring(3, 5);
		String nYear = date.substring(6, 10);
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");  
	    Date today = new Date(); 
	    String currentMonthYear= formatter.format(today);
	    
	    int aMonth = Integer.parseInt(nMonth);
	    int currentMonth = Integer.parseInt(currentMonthYear.substring(0,2));
	    int aYear = Integer.parseInt(nYear);		
	    int currentYear = Integer.parseInt(currentMonthYear.substring(3));
	    
		switch(nMonth)
		{
		case "01": month = "JANUARY"; break;
		case "02": month = "FEBRUARY"; break;
		case "03": month = "MARCH"; break;
		case "04": month = "APRIL"; break;
		case "05": month = "MAY"; break;
		case "06": month = "JUNE"; break;
		case "07": month = "JULY"; break;
		case "08": month = "AUGUST"; break;
		case "09": month = "SEPTEMBER"; break;
		case "10": month = "OCTOBER"; break;
		case "11": month = "NOVEMBER"; break;
		case "12": month = "DECEMBER"; break;
		default: month = "default Month";
		}
		String domMonthYear = dr.findElementById("label").getText();// september 2019
		String monthYear = month+" "+nYear;//october 2020
		while(!domMonthYear.equals(monthYear))
		{
			if( aMonth > currentMonth &&  aYear >= currentYear)
				dr.findElementById("next").click();
			else dr.findElementById("prev").click();
			domMonthYear = dr.findElementById("label").getText();
		}
		List<WebElement> tableRows = dr.findElementByXPath("//table[@class='curr']").findElements(By.tagName("tr"));
		int flag =0;
		for(WebElement eachRows:tableRows)
		{
			List<WebElement> tableData = eachRows.findElements(By.tagName("td"));
			for(WebElement eachData:tableData)
			{
				if(nDate.equals(eachData.getText()))
				{
					eachData.click();
					flag=1;
					break;
				}
			}
			if(flag==1) break;
		}

	}
}