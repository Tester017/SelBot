package com.selbot.testcases;

import java.util.Arrays;
import java.util.Collections;

public class test1 {

	public static void main(String[] args) {
		String a="as I am working and and drinking coffee a";
		String[] s = a.split(" ");
		StringBuilder d = new StringBuilder();
		for(int i=0;i<s.length;i++)
			System.out.println(s[i].length());
		for(int i=0;i<s.length;i++)
		{
			for(int j=i+1;j<s.length;j++)
			if(s[i].length()>s[j].length())
			{
				String h;
				h=s[i];
				s[i]=s[j];
				s[j]=h;
			}
		}
		for(int i=0;i<s.length;i++)
			System.out.print(s[i]+" ");
		
	}

}
