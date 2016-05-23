package com.quinnox.testautomation.service;

import java.util.HashMap;
import java.util.Set;

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
		if(difference.entriesDiffering().isEmpty() && difference.entriesInCommon().isEmpty()){
			return false;
		}
		return true;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String mappedValues(HashMap orderImportJsonMap, HashMap orderImportMap){
		MapDifference<String, Object> difference = Maps.difference(orderImportJsonMap, orderImportMap);
		String s = ""+difference.entriesInCommon();
		CommonValuesMapping mapping = new CommonValuesMapping();
		String entriesInCommon = mapping.commonValues(s);
		return difference.entriesDiffering()+" "+entriesInCommon;
		
	}
	
	public Boolean getOrderMappedValues(){
		HashMap<String, Integer> lineItemMap;
		OrderImportImpl orderImportImpl = new OrderImportImpl();
		lineItemMap = orderImportImpl.getLineItemsDetails();
		Set<String> itemNumberKey = lineItemMap.keySet();
		
		for(String keySet : itemNumberKey){
			if(keySet.contains("OC") && keySet.contains("OP") && keySet.contains("REF")){
				int result1 = lineItemMap.get(keySet);
				if( result1 == 0 ){
					return true;
				}
			}
			if(keySet.contains("ATO")){
				int result1 = lineItemMap.get(keySet);
				if( result1 != 0 ){
					return true;
				}
			}
		}
		return false;
	}
	
}
