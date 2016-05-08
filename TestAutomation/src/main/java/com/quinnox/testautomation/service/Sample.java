package com.quinnox.testautomation.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;



import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.quinnox.testautomation.dao.OrderImport;
import com.quinnox.testautomation.dao.OrderImportImpl;
import com.quinnox.testautomation.genericlib.ExcelLib;
import com.quinnox.testautomation.genericlib.JsonHelper;
import com.quinnox.testautomation.genericlib.JsonToMapLib;



public class Sample {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws InvalidFormatException, IOException, ParseException {
		
		OrderImport orderImport = new OrderImportImpl();
		Map orderImportMap;
		orderImportMap = orderImport.getOrderHeaderDetails();
		//System.out.println(orderImportMap);
		
		ExcelLib excelLib = new ExcelLib();
		//System.out.println(excelLib.getExcelData("Sheet1", 0, 0));
		
		String jsonString = excelLib.getExcelData("Sheet1", 0, 0);
		
		JSONObject jsonObject = new JSONObject(jsonString);
		//System.out.println(jsonObject.keySet());
		Iterator<String> keysItr = jsonObject.keys();
		while(keysItr.hasNext()){
			String key = keysItr.next();
			Object value = jsonObject.get(key);
			//System.out.println(value);
			
			if(value instanceof JSONArray){
				//List<Map<String, Object>> listOfMap = new ArrayList<Map<String,Object>>();
				//System.out.println(((JSONArray) value).length());
				for (int i = 0; i < ((JSONArray) value).length(); i++) {
					Object jsonArrayValue = ((JSONArray) value).get(i);
					//System.out.println(jsonArrayValue);
					
					if(jsonArrayValue instanceof JSONObject){
						JSONObject jobj = (JSONObject) jsonArrayValue;
						System.out.println(jobj.keySet());
						//System.out.println("==============================================");
						
						Iterator<String> subKeyItr = jobj.keys();
						while(subKeyItr.hasNext()){
							String subKey = subKeyItr.next();
							Object subValue = jobj.get(subKey);
							//System.out.println("*********************************************");
							//System.out.println(subValue);
							if(subValue instanceof JSONObject){
								JSONObject jsonobj = (JSONObject) subValue;
								System.out.println(jsonobj.keySet());
								System.out.println("============"+jsonobj.get("numberOfInstallments"));
								
							}
						}
					}
				}
			}
			if(value instanceof JSONObject){
				
				//System.out.println("=========JSON OBJECT=======");
				//System.out.println(value);
				JSONObject jsonObjectKeySet = (JSONObject) value;
				//System.out.println(jsonObjectKeySet.keySet());
			}
		}
		
		//System.out.println(jsonObject);		
		//Map<String, Object> arrayMap = new HashMap<String, Object>();
		//Map orderImportJsonMap;
		//System.out.println(JsonToMapLib.jsonToMap(jsonObject));
	
		//orderImportJsonMap = JsonToMapLib.jsonToMap(jsonObject);
		
		
		/*
		Set<String> s1 = orderImportJsonMap.keySet();
		JsonHelper jsonHelper = new JsonHelper();
		for(String set1 : s1){
			//System.out.println(orderImportJsonMap.get(set1));
			Object val = orderImportJsonMap.get(set1);
			if(val instanceof ArrayList){
				System.out.println("True");
				//System.out.println(((ArrayList) val));
				JSONObject jsonObject2 = new JSONObject(val);
				jsonHelper.toMap(jsonObject2);
				
			} */
		
		
//		System.out.println(orderImportJsonMap.get("payments"));
//		Object val = orderImportJsonMap.get("payments");
//		if(val instanceof ArrayList){
//			System.out.println("True");
//			
//		}
//		Sample sam = new Sample();
//		sam.compareMap(orderImportMap, orderImportJsonMap);
		
		
	}
	public void compareMap(Map<String, Object> map1 , Map<String, Object> map2){
		
		if(map1 == null || map2 ==null)
			System.out.println("False 1");
		
		int map1Size = map1.size();
		int map2Size = map2.size();
		System.out.println(map2.keySet());
				
		//System.out.println(((ArrayList)map2.get("payments")));
		//System.out.println("CUSTOMER_EMAIL_ADDRESS".replaceAll("_", "").toLowerCase().contains("customerEmail".toLowerCase()));
	}
}
