package com.quinnox.testautomation.service;

import java.util.HashMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.quinnox.testautomation.dao.OrderImport;
import com.quinnox.testautomation.dao.OrderImportImpl;
import com.quinnox.testautomation.genericlib.CommonValuesMapping;
import com.quinnox.testautomation.genericlib.JsonHelper;


public class OrderImortService {
	@SuppressWarnings({ "rawtypes" })
	public HashMap getDBMap(){
		OrderImport orderImport = new OrderImportImpl();
		HashMap orderImportMap;
		orderImportMap = orderImport.getOrderHeaderDetails();
		return orderImportMap;
	}
	
	@SuppressWarnings({ "rawtypes", "static-access" })
	public HashMap getJsonMap(String jsonString){
		JsonHelper helper = new JsonHelper();
		HashMap orderImportJsonMap;
		orderImportJsonMap = helper.createHashMapFromJsonString(jsonString.toLowerCase());
		return orderImportJsonMap;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean compareDBMapAndJsonMap(HashMap orderImportJsonMap, HashMap orderImportMap){
		MapDifference<String, Object> difference = Maps.difference(orderImportJsonMap, orderImportMap);
		//System.out.println(difference.entriesDiffering());
		//System.out.println(difference.entriesInCommon());
		if(difference.entriesDiffering().isEmpty() && difference.entriesInCommon().isEmpty()){
			return false;
		}
		return true;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String mappedValues(HashMap orderImportJsonMap, HashMap orderImportMap){
		MapDifference<String, Object> difference = Maps.difference(orderImportJsonMap, orderImportMap);
		//System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
		//System.out.println(difference.entriesDiffering());
		//System.out.println(difference.entriesInCommon());
		//System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
		String s = ""+difference.entriesInCommon();
		CommonValuesMapping mapping = new CommonValuesMapping();
		String entriesInCommon = mapping.commonValues(s);
		return difference.entriesDiffering()+" "+entriesInCommon;
		
	}
	
}
