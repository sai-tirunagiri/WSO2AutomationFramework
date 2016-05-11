package com.quinnox.testautomation.genericlib;

public class CommonValuesMapping {
	public String commonValues(String str){
		String originalString = str;
		//System.out.println(originalString);
		String[] splittedString = originalString.split(",");
		//System.out.println(splittedString[0].replace("{", "")+", 张佳佳");
		//System.out.println(splittedString[1]+", 123456789111");
		//System.out.println(splittedString[2].replace("}", "")+", narayan@motorola.com");
		return splittedString[0].replace("{", "")+", 张佳佳"+splittedString[1]+", 123456789111"+splittedString[2].replace("}", "")+", narayan@motorola.com";
	}
}
