package com.selbot.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class test {

	public static void main(String[] args) {
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");  
	    Date today = new Date(); 
System.out.println(today);
System.out.println(formatter.format(today));


	}
	
	@Test @Ignore
	public void test1()
	{
		String a="Daniel";
		String b="Daniel";
		char[] s = a.toCharArray();
		if(a.equals(b)) System.out.println("true");
		else System.out.println("false");		
	}
	
	@Test @Ignore
	public void test2()
	{
		String a="danie";
		char[] s = a.toCharArray();
		int flag = 0,j=0;
		for(int i=(s.length-1);i>=0;i--)
		{
			if(s[i]!=s[j]) flag=1;
			j++;
		}
		if(flag==0) System.out.println("plaindrome");
		else System.out.println("not pali");		
	}
	
	@Test @Ignore
	public void test3()
	{
		for(int j=1;j<=10000;j++)
		{
		int a = j,flag=0;
		char[] e = Integer.toString(a).toCharArray();
		for(int i=1;i<e.length;i++)
		{
			if(e[0]!=e[i]) flag=1;
		}
		if(flag==0) System.out.println(a);
		}
		
	}
	


}
