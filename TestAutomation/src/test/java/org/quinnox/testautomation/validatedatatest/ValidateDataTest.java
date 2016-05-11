package org.quinnox.testautomation.validatedatatest;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.quinnox.testautomation.genericlib.ExcelLib;
import com.quinnox.testautomation.service.OrderImortService;

public class ValidateDataTest {
	ExcelLib eLib;
	OrderImortService orderImortService;
	@SuppressWarnings("rawtypes")
	HashMap dbMap;
	@SuppressWarnings("rawtypes")
	HashMap jsonMap;
	@BeforeMethod
	public void initialize(){
		eLib = new ExcelLib();
		orderImortService = new OrderImortService();
	}
	
	@Test(priority=3)
	public void validateDataTest(){
		System.setProperty("file.encoding", "UTF-8");
		//Step 1: Get the data from the R12 table and convert to map
		dbMap = orderImortService.getDBMap();
		
		//Step 2: Get the json from the excel
		String jsonString = null;
		try {
			jsonString = eLib.getExcelData("Sheet1", 0, 0);
		} catch (InvalidFormatException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//Step 3: Convert the json to map
		jsonMap = orderImortService.getJsonMap(jsonString);
		
		//Step 5: compare two maps
		Assert.assertEquals(orderImortService.compareDBMapAndJsonMap(jsonMap, dbMap),true,"One or more values failed to validate");
		
		//Step 4: Display the values that is getting mapped
		System.out.println(" ");
		System.out.println("==============================================================================================");
		System.out.println("Json data which are mapped to the respective table column");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		try{
			PrintStream out = new PrintStream(System.out, true, "EUC_CN");
	        System.setOut(out);
            System.out.println(orderImortService.mappedValues(jsonMap, dbMap));
            //orderImortService.mappedValues(jsonMap, dbMap);
		}
		catch(UnsupportedEncodingException e){
			System.out.println(e);
		}
		//System.out.println(orderImortService.mappedValues(jsonMap, dbMap));
		System.out.println("==============================================================================================");
		System.out.println(" ");
		
	}
}
