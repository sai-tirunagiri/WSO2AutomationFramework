package org.quinnox.testautomation.verifypostrequest;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpResponse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.quinnox.testautomation.genericlib.CommonLib;
import com.quinnox.testautomation.genericlib.ExcelLib;

public class VerifyPostRequestTest {
	ExcelLib eLib;
	CommonLib cLib;
	
	@BeforeClass
	public void configBeforeClass(){
		
		//objet intalization
		eLib = new ExcelLib();
		cLib = new CommonLib();			
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=2)
	public void verifyPostRequest() throws IOException, JSONException, InvalidFormatException, KeyManagementException, NoSuchAlgorithmException{
		//Step 1: Get the Rest URL
		String Resturl = "http://100.66.134.247:8280/orders/sources/ops";
		
		String jsonString = null;
		try {
			jsonString = eLib.getExcelData("Sheet1", 0, 0);
		} catch (InvalidFormatException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		//step 2: map the rest URL and get the response from the API
		HttpResponse response = cLib.sendJSon(Resturl, jsonString);
		Assert.assertTrue(response.toString().contains("200"));
		System.out.println(" ");
		System.out.println("======================================================");
		System.out.println("*****POST DATA TO API IS SUCCESS!*****");
		System.out.println("======================================================");
		System.out.println(" ");
	}
}
