package org.quinnox.testautomation.verifyapistatus;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.quinnox.testautomation.genericlib.CommonLib;
import com.quinnox.testautomation.genericlib.ExcelLib;


public class VerifyRestApiStatus {
	ExcelLib eLib;
	CommonLib cLib;
	
	@BeforeClass
	public void configBeforeClass(){
		
		//objet intalization
		eLib = new ExcelLib();
		cLib = new CommonLib();			
	}
	
	@Test(priority=1)
	public void verifyApiStatus() throws IOException, JSONException, InvalidFormatException, KeyManagementException, NoSuchAlgorithmException{
		//Step 1: Get the Rest URL
		String Resturl = "http://100.66.134.247:8280/orders/sources/ops";
		//String recentRecordValue = excelLib.getExcelData("Sheet2", 0, 0);
		
		//step 2: map the rest URL and get the response from the API
		int statusCode = cLib.getApiStatus(Resturl);
		
		Assert.assertEquals(statusCode, 202,"API is down! Please check!");
		System.out.println(" ");
		System.out.println("======================================================");
		System.out.println("*****API IS UP AND RUNNING*****");
		System.out.println("======================================================");
		System.out.println(" ");
	}
}
