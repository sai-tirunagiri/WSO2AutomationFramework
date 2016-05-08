package com.quinnox.testautomation.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;



import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.quinnox.testautomation.dao.OrderImport;
import com.quinnox.testautomation.dao.OrderImportImpl;
import com.quinnox.testautomation.genericlib.ExcelLib;
import com.quinnox.testautomation.genericlib.JsonToMapLib;


public class Sample {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws InvalidFormatException, IOException, ParseException {
		OrderImport orderImport = new OrderImportImpl();
		Map orderImportMap;
		orderImportMap = orderImport.getOrderHeaderDetails();
		System.out.println(orderImportMap);
		
		ExcelLib excelLib = new ExcelLib();
		//System.out.println(excelLib.getExcelData("Sheet1", 0, 0));
		
		//String jsonString = excelLib.getExcelData("Sheet1", 0, 0);
		
		//JSONParser jsonParser = new JSONParser();
		//JSONObject jsonObject = new JSONObject(jsonString);
		
		
		//System.out.println(jsonObject);
		Map orderImportJsonMap;
		//System.out.println(JsonToMapLib.jsonToMap(jsonObject));
		//orderImportJsonMap = JsonToMapLib.jsonToMap(jsonObject);
		//System.out.println(orderImportJsonMap.get("payments"));
		Sample sam = new Sample();
		//sam.compareMap(orderImportMap, orderImportJsonMap);
	}
	public void compareMap(Map<Object, Object> map1 , Map<String, Object> map2){
		
		if(map1 == null || map2 ==null)
			System.out.println("False 1");
		
		int map1Size = map1.size();
		int map2Size = map2.size();
		
		System.out.println(map1Size);
		System.out.println(map2Size);
		
		System.out.println(map1.entrySet());
		//Set<String> s1 = map1.keySet();
		Set<String> s2 = map2.keySet();
		
		//System.out.println(map1.values().contains(map2.values()));
		
		System.out.println(map2.entrySet());

		System.out.println("CUSTOMER_EMAIL_ADDRESS".replaceAll("_", "").toLowerCase().contains("customerEmail".toLowerCase()));
	}
}
